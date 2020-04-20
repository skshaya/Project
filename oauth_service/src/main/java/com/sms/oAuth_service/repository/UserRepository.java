package com.sms.oAuth_service.repository;

import java.util.Optional;

import com.sms.oAuth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer>{
	
	Optional<User> findByUsername(String name);
    
}
