package com.webnoithat.identity_service.dtos;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
	String username;
	String password;
}
