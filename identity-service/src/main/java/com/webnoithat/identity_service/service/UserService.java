package com.webnoithat.identity_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webnoithat.identity_service.dtos.UserCreationRequest;
import com.webnoithat.identity_service.dtos.UserResponse;
import com.webnoithat.identity_service.dtos.UserUpdateRequest;
import com.webnoithat.identity_service.entities.User;
import com.webnoithat.identity_service.exception.AppException;
import com.webnoithat.identity_service.exception.ErrorCode;
import com.webnoithat.identity_service.mapper.UserMapper;
import com.webnoithat.identity_service.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

	UserRepository userRepository;

	UserMapper userMapper;

	public User createUser(UserCreationRequest request) {

		if (userRepository.existsByUsername(request.getUsername()))
			throw new AppException(ErrorCode.USER_EXISTED);

		User user = userMapper.toUser(request);

		return userRepository.save(user);
	}

	public List<User> getUser() {
		return userRepository.findAll();
	}

	public UserResponse getUserById(UUID id) {
		return userMapper.toUserResponse(
				userRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng")));
	}

	public UserResponse updateUser(UUID userId, UserUpdateRequest request) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));

		userMapper.updateUser(user, request);
		return userMapper.toUserResponse(userRepository.save(user));
	}

	public void deleteUser(UUID userId) {
		userRepository.deleteById(userId);
	}
}
