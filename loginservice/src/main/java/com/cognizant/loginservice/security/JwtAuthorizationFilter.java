package com.cognizant.loginservice.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.loginservice.exception.UsernameNotFound;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager)throws UsernameNotFound {
        super(authenticationManager);
        log.info("Start of JwtAuthorization filter");
        log.debug("{Authentication Manager}: ", authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        log.info("Start of doFilterInternal");
        String header = req.getHeader("Authorization");
        log.debug(header);
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        log.debug("authentication" + authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
        log.info("========");
        log.debug("req++++++++++++:" + req + " res:" + res);
        log.info("End of doFilterInternal");
    }


    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws UsernameNotFound {
        log.info("Start of UsernamePasswordAuthenticationToken");
        String token = request.getHeader("Authorization");
        log.debug("token"+token);
        if (token != null) {
            // parse the token.
            Jws<Claims> jws;
            try {
                jws = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token.replace("Bearer ", ""));
                String user = jws.getBody().getSubject();
                log.debug("Inside try+++++++"+user);
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }
            } catch (JwtException ex) {
                return null;
            }
            catch(BadCredentialsException e){
                throw new UsernameNotFound("Invalid credentials");
            }

            return null;
        }
        return null;
    }
}