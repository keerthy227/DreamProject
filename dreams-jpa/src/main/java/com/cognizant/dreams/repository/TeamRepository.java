package com.cognizant.dreams.repository;
import com.cognizant.dreams.entity.jpa.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value="Select * from Team where user_id=?", nativeQuery = true)
    List<Team> getTeam(long id);

    @Query(value = "Select * from Team where team_name=? and user_id=? and session_id is null",nativeQuery = true)
    Team gettheTeam(String teamName, long userId);

    @Query(value = "Select user_id from Team where role='facilitator' and  limit 1 ",nativeQuery = true)
    long getFacilitator(String teamName, long userID);

    @Query(value = "Select * from Team where team_name=? and user_id=? limit 1" , nativeQuery = true)
    Team getexistingTeam(String teamName, Long userId);

    @Query(value ="Select * from Team where team_name=? ",nativeQuery = true)
    List<Team> getTeamMembers(String teamname);

}
