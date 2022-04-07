package edu.miu.service;

import edu.miu.domain.dto.request.LoginRequest;
import edu.miu.domain.dto.request.RefreshTokenRequest;
import edu.miu.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
