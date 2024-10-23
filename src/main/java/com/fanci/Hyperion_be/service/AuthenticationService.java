package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.AuthenticationRequest;
import com.fanci.Hyperion_be.dto.request.IntrospectRequest;
import com.fanci.Hyperion_be.dto.request.LogoutRequest;
import com.fanci.Hyperion_be.dto.request.RefreshTokenRequest;
import com.fanci.Hyperion_be.dto.response.AuthenticationResponse;
import com.fanci.Hyperion_be.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest request) throws JOSEException;

    void logout(LogoutRequest request) throws ParseException, JOSEException;

    IntrospectResponse introspect(IntrospectRequest request);

    AuthenticationResponse refreshToken(RefreshTokenRequest request) throws ParseException, JOSEException;
}
