package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.request.AuthenticationRequest;
import com.fanci.Hyperion_be.dto.request.IntrospectRequest;
import com.fanci.Hyperion_be.dto.request.LogoutRequest;
import com.fanci.Hyperion_be.dto.request.RefreshTokenRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.AuthenticationResponse;
import com.fanci.Hyperion_be.dto.response.IntrospectResponse;
import com.fanci.Hyperion_be.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("login")
    public ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws JOSEException {
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authenticationService.login(request))
                .build();
    }

    @PostMapping("introspect")
    public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request){
        return ApiResponse.<IntrospectResponse>builder()
                .result(authenticationService.introspect(request))
                .build();
    }

    @PostMapping("logout")
    public  ApiResponse<?> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.builder().build();
    }

    @PostMapping("refresh")
    public ApiResponse<AuthenticationResponse> refresh(@RequestBody RefreshTokenRequest request) throws ParseException, JOSEException {
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authenticationService.refreshToken(request))
                .build();
    }
}
