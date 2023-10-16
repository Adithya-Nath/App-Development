package com.blooddonation.main.service;

import com.blooddonation.main.dto.request.AuthenticationRequest;
import com.blooddonation.main.dto.request.RegisterRequest;
import com.blooddonation.main.dto.response.AuthenticationResponse;

public interface AuthService {
    boolean userRegistration(RegisterRequest request);

    AuthenticationResponse userAuthentication(AuthenticationRequest request);

}
