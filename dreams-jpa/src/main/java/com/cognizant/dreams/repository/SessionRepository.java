package com.cognizant.dreams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.dreams.entity.jpa.RetroSession;

import javax.transaction.Transactional;

@Repository
public interface SessionRepository  extends CrudRepository<RetroSession,Long> {
    @Query(value = "Select count(retroses_id) from retro_session where retrosession_id=? " +
            "AND user_id=?", nativeQuery = true)
    Long findCountToSave(String sessionId, long userId);

    @Query(value = "Select count(retroses_id) from retro_session where retrosession_id=?", nativeQuery = true)
    Long findCount(String sessionId);


    public RetroSession findByRetroSessionIdAndRole(String retroSessionId,String  role);

    @Query(value = "select user_id from retro_session where retrosession_id =?", nativeQuery = true)
    List<Long> findAllUserByRetroSessionId(String sessionId);

	
    @Query(value = "select * from retro_session where retrosession_id =?", nativeQuery = true)
    List<RetroSession> findAllByRetroSessionId(String sessionId);
	
	 @Query(value = "Select * from retro_session where retrosession_id=?",nativeQuery = true)
    RetroSession[] getSession(String id);

    @Query(value = "Select * from retro_session where team_name=?"+" and user_id=? ",nativeQuery = true)
    List<RetroSession> getallteamsession(String teamname, long id);

    @Query(value = "select retrosession_id from retro_session where team_name=? " + "and user_id=?", nativeQuery = true)
    List<String> getSessionID(String teamname , long id);

    @Query(value = "Select * from retro_session where retrosession_id=?"+" and role='facilitator'" , nativeQuery = true)
    RetroSession getsessiondetails(String sessionId);

    @Query(value = "select user_id from retro_session where retrosession_id=(Select retrosession_id from retro_session where user_id=? and team_name=? limit 1) limit 1",nativeQuery = true)
    long getfacilitator(long userId,String teamname);

    @Modifying
    @Transactional
    @Query(value = "Update retro_session status=false where retrosession_id=?",nativeQuery = true)
   void endSession(String sessionId);
}
