package com.cognizant.dreams.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.dreams.entity.jpa.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	@Query(value = "select id from USER where user_name =?", nativeQuery = true)
	Long findIdByUserName(String username);

	@Query(value = "select * from USER where user_name =?", nativeQuery = true)
	User findByUserName(String userName);

	@Query(value = "select * from USER where email =?", nativeQuery = true)
	User findByEmail(String email);

	@Query(value = "select * from USER where id =?", nativeQuery = true)
	List<User> findAllUserById(Long userId);
	
	  
}
