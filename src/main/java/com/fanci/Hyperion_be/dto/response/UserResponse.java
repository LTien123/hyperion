package com.fanci.Hyperion_be.dto.response;

import com.fanci.Hyperion_be.dto.RoleDto;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private Boolean isActive;
    private String thumbnailUrl;
    private String thumbnailPublicId;
    private Set<RoleDto> roleDtos;
}
