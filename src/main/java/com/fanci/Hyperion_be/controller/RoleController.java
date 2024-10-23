package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.request.CreateNewRoleRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.RoleResponse;
import com.fanci.Hyperion_be.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping()
    ApiResponse<List<RoleResponse>> findAllRoles(){
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.findAllRole())
                .build();
    }

    @PostMapping()
    ApiResponse<RoleResponse> addNewRole(@RequestBody CreateNewRoleRequest request){
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.addNewRole(request))
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<RoleResponse> findRoleById(@PathVariable Long id){
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.findRoleById(id))
                .build();
    }
}
