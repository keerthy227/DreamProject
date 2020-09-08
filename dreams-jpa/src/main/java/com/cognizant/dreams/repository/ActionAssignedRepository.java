package com.cognizant.dreams.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.dreams.entity.jpa.ActionAssigned;

import java.util.Collection;
import java.util.List;

@Repository
public interface ActionAssignedRepository extends JpaRepository<ActionAssigned, Long> {


    @Query(value = "select * from ACTION_ASSIGNED where retro_session_id =?", nativeQuery = true)
    List<ActionAssigned> findAllByRetroSessionId(String sessionId);

    @Query(value = "select id from ACTION_ASSIGNED where action_id=? and action_assigned_user_id =?", nativeQuery = true)
    Long findByActionAssignedUser(long actionId,long id);

    @Query(value = "Select * from ACTION_ASSIGNED where retro_session_id in(select retrosession_id from retro_session where team_name=? and user_id=? and status=false)",nativeQuery = true)
    List<ActionAssigned> findAllExistingActionAssigned(String teamname,long user_id);
}
