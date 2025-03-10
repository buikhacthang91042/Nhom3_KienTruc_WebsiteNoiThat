package com.webnoithat.identity_service.dtos;

import java.time.LocalDate;

import com.webnoithat.identity_service.exception.ErrorCode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserCreationRequest {
	
	@NotBlank(message = "Không được bỏ trống tên người dùng")
	@Size(min = 3, max = 20, message = "USERNAME_INVALID")
	private String username;
	
	@NotBlank(message = "Không được bỏ trống mật khẩu")
    @Size(min = 8, message = "PASSWORD_INVALID")
	private String password;
	
	@NotBlank(message = "Không được bỏ trống tên")
	private String firstName;
	
	@NotBlank(message = "Không được bỏ trống họ")
	private String lastName;
	
	@NotNull(message = "Không được bỏ trống ngày sinh")
	private LocalDate dob;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
}
