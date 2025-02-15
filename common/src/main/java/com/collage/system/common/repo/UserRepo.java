package com.collage.system.common.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collage.system.common.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select e from User e where e.email=:email")
	User findByEmail(@Param("email") String email);
	
	@Query("select e from User e where e.mobileNumber=:mobileNumber")
	User findByMobileNumber(@Param("mobileNumber") String mobileNumber);
	
	@Query("select e from User e where e.id=:id")
	User findById(@Param("id") int id);
	
	
	
}