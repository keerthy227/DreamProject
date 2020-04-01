package com.cognizant.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableCaching
@EnableEurekaClient
@SpringBootApplication
public class LoginserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginserviceApplication.class, args);
	}

}
