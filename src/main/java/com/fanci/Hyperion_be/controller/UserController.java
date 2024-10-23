package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.request.CreateNewUserRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.UserResponse;
import com.fanci.Hyperion_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ApiResponse<List<UserResponse>> findAllUser(){
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.findAllUser())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> findUserById(@PathVariable Long id){
        return ApiResponse.<UserResponse>builder()
                .result(userService.findUserById(id))
                .build();
    }

    @PostMapping()
    public ApiResponse<UserResponse> addNewUser(@ModelAttribute CreateNewUserRequest request) throws IOException {
        return ApiResponse.<UserResponse>builder()
                .result(userService.addNewUser(request))
                .build();
    }

}
