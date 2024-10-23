package com.fanci.Hyperion_be.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewUserRequest {
    private String username;
    private String password;
    private String rePassword;
    private String fullName;
    private String email;
    private String phone;
    private MultipartFile image;
    private Set<Long> roleId;
}
