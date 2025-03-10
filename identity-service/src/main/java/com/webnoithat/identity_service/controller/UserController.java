package com.webnoithat.identity_service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webnoithat.identity_service.dtos.ApiResponse;
import com.webnoithat.identity_service.dtos.UserCreationRequest;
import com.webnoithat.identity_service.dtos.UserUpdateRequest;
import com.webnoithat.identity_service.entities.User;
import com.webnoithat.identity_service.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	ApiResponse<User> createUser(@RequestBody @Valid  UserCreationRequest request ) {
		ApiResponse<User> apiResponse = new ApiResponse<>();
		apiResponse.setResult(userService.createUser(request));
		return apiResponse;
	} 
	
	@GetMapping
	List<User> getUser() {
		return userService.getUser();
	}
	
	@GetMapping("/{userId}")
	User getUserById(@PathVariable("userId") UUID userId) {
		return userService.getUserById(userId);
	}
	
	@PutMapping("/{userId}")
	User updateUser(@PathVariable UUID userId,  @RequestBody UserUpdateRequest request ) {
		return userService.updateUser(userId, request);
	}
	
	@DeleteMapping("/{userId}")
	String deleteUser(@PathVariable UUID userId) {
		userService.deleteUser(userId);
		return "User đã bị xóa";
	}
}
