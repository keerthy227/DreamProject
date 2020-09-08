package com.cognizant.dreams.repository;


import java.util.List;

import com.cognizant.dreams.entity.jpa.Notes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {


    @Query(value = "select notes_id from NOTES where retrosession_id =?", nativeQuery = true)
    List<Long> findAllNotesBySessionId(String sessionId);

    
    @Query(value="select * from NOTES where retrosession_id =?", nativeQuery = true)
    List<Notes> findAllNotesByRetroId(String retroSessionId);
}
