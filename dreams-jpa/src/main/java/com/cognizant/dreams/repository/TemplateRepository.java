package com.cognizant.dreams.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.dreams.entity.jpa.Template;

public interface TemplateRepository extends CrudRepository<Template, Long> {

    @Query(value = "select * from Template where id=?",nativeQuery = true)
    Template findtemplate(long id);
}
