package com.cognizant.userservice.service;

import com.cognizant.dreams.entity.TimerDTO;
import com.cognizant.dreams.entity.jpa.Timer;
import com.cognizant.dreams.repository.TimerRepository;
import com.cognizant.dreams.util.RetroUtil;
import com.cognizant.userservice.exception.TimerServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class TimerServiceImpl implements TimerService {

    @Autowired
    private TimerRepository timerRepository = null;

    @Autowired
    private RetroUtil retroUtil;

    @Cacheable("timer")
    public TimerDTO getTimeForSession(String sessionId) throws TimerServiceException {
        log.info("cache");
        try {
            if(timerRepository.existsBySessionId(sessionId)){
                log.info("db");
                Optional<Timer> timer1 = timerRepository.findBySessionId(sessionId);
                return retroUtil.convertToTimerDTO(timer1.get());
            }
            else{
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new TimerServiceException(e.getMessage());
        }
    }


    @CacheEvict(value="timer",allEntries=true)
    public String saveTime(TimerDTO time) throws TimerServiceException {
        try {
            Timer timer = retroUtil.convertToTimerJPA(time);
            String pattern = "HH:mm:ss";
            DateFormat df = new SimpleDateFormat(pattern);
            Date today = Calendar.getInstance().getTime();
            String currentTime = df.format(today);
            Optional<Timer> timer1 = Optional.empty();
            if(!timerRepository.existsBySessionId(timer.getSessionId())){
                timer.setSetTime(currentTime);
                timerRepository.save(timer);
                log.info(""+timer);
                return "1";
            }
            else{
                timer1 = timerRepository.findBySessionId(timer.getSessionId());
                timer1.get().setMin(timer.getMin());
                timer1.get().setSetTime(currentTime);
                timerRepository.save(timer1.get());
                log.info("jhdjhj"+timer1.get());
                return "2";
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new TimerServiceException(e.getMessage());
        }
    }


}
