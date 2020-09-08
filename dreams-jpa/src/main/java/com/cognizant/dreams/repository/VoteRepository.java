package com.cognizant.dreams.repository;


import com.cognizant.dreams.entity.jpa.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Query(value = "select id from VOTE where vote_notes_id = ? and user_id =?", nativeQuery = true)
    Long findByNoteId(Long noteId, Long userId);


    @Query(value = "select * from VOTE where session_id =?", nativeQuery = true)
    List<Vote> findAllByRetroSessionId(String sessionId);
}
