package com.fanci.Hyperion_be.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewPermissionRequest {
    private String permissionName;
    private String description;

}
