package com.cognizant.dreams.repository;

import com.cognizant.dreams.entity.jpa.StatusCheck;
import com.cognizant.dreams.entity.jpa.Team;
import com.cognizant.dreams.entity.jpa.Timer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusCheckRepository extends JpaRepository<StatusCheck, Long> {

    @Query(value = "select * from status_check where retro_session_id =?", nativeQuery = true)
    List<StatusCheck> findAllByRetroSessionId(String sessionId);

    boolean existsByRetroSessionId(String sessionId);

    @Query(value = "select * from status_check where user_id=? AND retro_session_id =?", nativeQuery = true)
    Optional<StatusCheck> findByUserIdAndSessionId(long userId,String sessionId);
}
