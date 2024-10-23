package com.fanci.Hyperion_be.dto.response;

import com.fanci.Hyperion_be.dto.PermissionDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponse {
    private Long id;
    private String roleName;
    private List<PermissionDto> permissionDtoList;
}
