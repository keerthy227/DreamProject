package com.cognizant.dreams.repository;


import com.cognizant.dreams.entity.jpa.ActionComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionCommentsRepository  extends JpaRepository<ActionComments, Long> {

    @Query(value = "select * from action_comments where retrosession_id =?", nativeQuery = true)
    List<ActionComments> findAllByRetroSessionId(String sessionId);


    @Query(value = "Select * from ACTION_COMMENTS where retrosession_id in(select retrosession_id from retro_session where team_name=? and user_id=? and status=false)",nativeQuery = true)
    List<ActionComments> findAllExistingActionComments(String teamname,long user_id);
}

