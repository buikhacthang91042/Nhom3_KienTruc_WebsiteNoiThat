package com.webnoithat.identity_service.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
	
	@NotBlank(message = "Không được bỏ trống tên người dùng")
	@Size(min = 3, max = 20, message = "USERNAME_INVALID")
	String username;
	
	@NotBlank(message = "Không được bỏ trống mật khẩu")
    @Size(min = 8, message = "PASSWORD_INVALID")
	String password;
	
	@NotBlank(message = "Không được bỏ trống tên")
	String firstName;
	
	@NotBlank(message = "Không được bỏ trống họ")
	String lastName;
	
	@NotNull(message = "Không được bỏ trống ngày sinh")
	LocalDate dob;
	
}
