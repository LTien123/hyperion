package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.RoleDto;
import com.fanci.Hyperion_be.dto.response.RoleResponse;
import com.fanci.Hyperion_be.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponse toRoleResponse(Role role);

    RoleDto toRoleDto(Role role);
}
