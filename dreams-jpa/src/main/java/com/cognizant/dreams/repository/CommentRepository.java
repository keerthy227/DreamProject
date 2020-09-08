package com.cognizant.dreams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.dreams.entity.jpa.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select * from COMMENT where comment_notes_id =?", nativeQuery = true)
    List<Comment> findAllCommentsById(Long note);
}
