package com.cognizant.userservice.service;

import com.cognizant.dreams.entity.StatusCheckDTO;
import com.cognizant.dreams.entity.jpa.StatusCheck;
import com.cognizant.dreams.repository.StatusCheckRepository;
import com.cognizant.dreams.util.RetroUtil;
import com.cognizant.userservice.exception.StatusServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StatusServiceImpl implements StatusService{

    @Autowired
    private StatusCheckRepository statusCheckRepository = null;

    @Autowired
    private RetroUtil retroUtil;

    @Cacheable("status")
    public List<StatusCheckDTO> getStatusForSession(String sessionId) throws StatusServiceException {
        try{
            List<StatusCheck> check = new ArrayList<>();
            List<StatusCheckDTO> checkDTO = new ArrayList<>();
            log.info("xshxgh"+statusCheckRepository.existsByRetroSessionId(sessionId));
            if(statusCheckRepository.existsByRetroSessionId(sessionId)){
                log.info(""+statusCheckRepository.findAllByRetroSessionId(sessionId));
                check = statusCheckRepository.findAllByRetroSessionId(sessionId);
                checkDTO.addAll(check.stream().map(obj->retroUtil.convertToStatusCheckDTO(obj)).
                        collect(Collectors.toList()));
                return checkDTO;
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new StatusServiceException(e.getMessage());
        }
    }

    @CacheEvict(value="status",allEntries=true)
    public void saveStatus(StatusCheckDTO status)  throws StatusServiceException{
        try{
            log.info(""+status);
            StatusCheck statusCheck = retroUtil.convertToStatusCheckJPA(status);
            Optional<StatusCheck> check = Optional.empty();
            if(!statusCheckRepository.findByUserIdAndSessionId(status.getUserId(),status.getRetroSessionId()).isPresent()){
                statusCheckRepository.save(statusCheck);
            }else{
                check = statusCheckRepository.findByUserIdAndSessionId(status.getUserId(),status.getRetroSessionId());
                check.get().setCurrentScreen(status.getCurrentScreen());
                check.get().setStatusOfScreen(status.isStatusOfScreen());
                check.get().setRole(status.getRole());
                statusCheckRepository.save(check.get());
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new StatusServiceException(e.getMessage());
        }
    }
}
