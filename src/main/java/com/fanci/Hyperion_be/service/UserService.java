package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewUserRequest;
import com.fanci.Hyperion_be.dto.request.UpdateUserRequest;
import com.fanci.Hyperion_be.dto.response.UserResponse;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserResponse> findAllUser();

    UserResponse findUserById(Long id);

    UserResponse addNewUser(CreateNewUserRequest request) throws IOException;

    UserResponse updateUser(UpdateUserRequest request, Long id) throws IOException;

    void deleteUser(Long id);
}
