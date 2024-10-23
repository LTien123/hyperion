package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.request.CreateNewPermissionRequest;
import com.fanci.Hyperion_be.dto.response.PermissionResponse;
import com.fanci.Hyperion_be.entity.Permission;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.PermissionMapper;
import com.fanci.Hyperion_be.repository.PermissionRepository;
import com.fanci.Hyperion_be.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    private final PermissionMapper permissionMapper;
    @Override
    public List<PermissionResponse> findAllPermission(){
        return permissionRepository.findAll().stream().map(this::toPermissionResponse).toList();
    }
    @Override
    public PermissionResponse findPermissionById(Long id){
        var permission = permissionRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PERMISSION_ID_NOT_FOUND));

        return toPermissionResponse(permission);
    }
    @Override
    public PermissionResponse addNewPermission(CreateNewPermissionRequest request){
        if(permissionRepository.findPermissionByPermissionName(request.getPermissionName()).isPresent()){
            throw new AppException(ErrorCode.PERMISSION_NAME_DUPLICATED);
        }
        Permission permissionRaw = Permission.builder()
                .permissionName(request.getPermissionName())
                .description(request.getDescription())
                .build();

       Permission permission = permissionRepository.save(permissionRaw);
       return toPermissionResponse(permission);
    }

    private PermissionResponse toPermissionResponse(Permission permission) {
        return permissionMapper.toPermissionResponse(permission);
    }

}
