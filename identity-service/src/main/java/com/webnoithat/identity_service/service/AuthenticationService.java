package com.webnoithat.identity_service.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.webnoithat.identity_service.dtos.AuthenticationRequest;
import com.webnoithat.identity_service.exception.AppException;
import com.webnoithat.identity_service.exception.ErrorCode;
import com.webnoithat.identity_service.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
	UserRepository userRepository;

	public boolean authenticate(AuthenticationRequest authenticationRequest) {
		var user = userRepository.findByUsername(authenticationRequest.getUsername())
				.orElseThrow(() -> new AppException(ErrorCode.USER_NONEXISTED));
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		return passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
	}
}
