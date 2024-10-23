package com.fanci.Hyperion_be.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private boolean isAuthenticated;
    private String token;
}
