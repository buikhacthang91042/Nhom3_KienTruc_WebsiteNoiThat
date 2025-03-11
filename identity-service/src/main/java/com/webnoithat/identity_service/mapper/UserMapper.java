package com.webnoithat.identity_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.webnoithat.identity_service.dtos.UserCreationRequest;
import com.webnoithat.identity_service.dtos.UserResponse;
import com.webnoithat.identity_service.dtos.UserUpdateRequest;
import com.webnoithat.identity_service.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User toUser(UserCreationRequest request);
	
	
	void updateUser(@MappingTarget User user, UserUpdateRequest request);
	
	//@Mapping(source = "", target = "")
	UserResponse toUserResponse (User user);
	
}
