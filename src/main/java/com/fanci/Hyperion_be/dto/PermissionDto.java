package com.fanci.Hyperion_be.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionDto {
    private Long id;
    private String permissionName;

}
