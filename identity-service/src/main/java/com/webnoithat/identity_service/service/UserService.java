package com.webnoithat.identity_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webnoithat.identity_service.dtos.UserCreationRequest;
import com.webnoithat.identity_service.dtos.UserUpdateRequest;
import com.webnoithat.identity_service.entities.User;
import com.webnoithat.identity_service.exception.AppException;
import com.webnoithat.identity_service.exception.ErrorCode;
import com.webnoithat.identity_service.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User createUser (UserCreationRequest request) {
				User user = new User();
				
				if(userRepository.existsByUsername(request.getUsername()))
					throw new AppException(ErrorCode.USER_EXISTED);
				
				
				user.setUsername(request.getUsername());
				user.setPassword(request.getPassword());
				user.setFirstName(request.getFirstName());
				user.setLastName(request.getLastName());
				user.setDob(request.getDob());
				
				return userRepository.save(user);
	}
	
	public List<User> getUser() {
		return userRepository.findAll();
	}
	
	public User getUserById(UUID id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
	}
	
	public User updateUser(UUID userId, UserUpdateRequest request) {
		User user = getUserById(userId);
		
		user.setPassword(request.getPassword());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setDob(request.getDob());
		
		return userRepository.save(user);
	}
	
	public void deleteUser(UUID userId) {
		 userRepository.deleteById(userId);
	}
}
