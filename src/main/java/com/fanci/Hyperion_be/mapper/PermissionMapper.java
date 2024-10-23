package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.PermissionDto;
import com.fanci.Hyperion_be.dto.response.PermissionResponse;
import com.fanci.Hyperion_be.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionResponse toPermissionResponse(Permission permission);
    PermissionDto toPermissionDto(Permission permission);
}
