package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.UserDto;
import com.fanci.Hyperion_be.dto.request.CreateNewUserRequest;
import com.fanci.Hyperion_be.dto.response.UserResponse;
import com.fanci.Hyperion_be.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    UserResponse toUserResponse(User user);

    User toUser(CreateNewUserRequest request);

}
