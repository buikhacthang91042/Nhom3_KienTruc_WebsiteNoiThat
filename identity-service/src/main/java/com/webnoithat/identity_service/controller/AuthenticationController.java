package com.webnoithat.identity_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webnoithat.identity_service.dtos.ApiResponse;
import com.webnoithat.identity_service.dtos.AuthenticationRequest;
import com.webnoithat.identity_service.dtos.AuthenticationResponse;
import com.webnoithat.identity_service.service.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
	AuthenticationService authenticationService;
	
	@PostMapping("/log-in")
	ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
		boolean result =authenticationService.authenticate(authenticationRequest);
		return ApiResponse.<AuthenticationResponse>builder()
				.result(AuthenticationResponse.builder()
						.authenticated(result)
						.build())
				.build();
			
	}
}
