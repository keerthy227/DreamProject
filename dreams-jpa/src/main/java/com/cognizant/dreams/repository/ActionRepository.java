package com.cognizant.dreams.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.dreams.entity.jpa.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {


    @Query(value = "select * from ACTION where retrosession_id =?", nativeQuery = true)
    List<Action> findAllByRetroSessionId(String sessionId);

    @Query(value = "Select * from action where retrosession_id in(select retrosession_id from retro_session where team_name=? and user_id=? and status=false)",nativeQuery = true)
    List<Action> findAllExistingAction(String teamname,long user_id);

}

