package com.webnoithat.identity_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webnoithat.identity_service.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	
		boolean existsByUsername(String username);
		
	
}
