package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.request.CreateNewPermissionRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.PermissionResponse;
import com.fanci.Hyperion_be.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("permission")
public class PermissionController {
    private final PermissionService permissionService;

    @GetMapping()
    ApiResponse<List<PermissionResponse>> getAllPermission(){
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.findAllPermission())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<PermissionResponse> getPermissionById(@PathVariable Long id){
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.findPermissionById(id))
                .build();
    }

    @PostMapping()
    ApiResponse<PermissionResponse> addNewPermission(@RequestBody CreateNewPermissionRequest request){
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.addNewPermission(request))
                .build();
    }

}
