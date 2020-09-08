package com.cognizant.dreams.repository;


import com.cognizant.dreams.entity.jpa.Timer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimerRepository extends CrudRepository<Timer, Long> {

    @Query(value = "select * from TIMER where session_id =?", nativeQuery = true)
    Optional<Timer> findBySessionId(String sessionId);

    @Query(value = "delete from TIMER where session_id =?", nativeQuery = true)
    void deleteBySessionId(String sessionId);

    boolean existsBySessionId(String sessionId);
}
