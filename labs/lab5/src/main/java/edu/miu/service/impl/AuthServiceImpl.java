package edu.miu.service.impl;


import edu.miu.domain.dto.request.LoginRequest;
import edu.miu.domain.dto.request.RefreshTokenRequest;
import edu.miu.domain.dto.response.LoginResponse;
import edu.miu.service.AuthService;
import edu.miu.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    /*
    My way of doing this
    define a class variable and use it do the checking
    * **/
//     static String activeTooken = null;


    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getEmail());

        final String accessToken = jwtUtil.generateToken(userDetails);
//        activeTooken = accessToken;
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {

            Date tokenExpiredDate = jwtUtil.getExpirationDateFromToken(refreshTokenRequest.getAccessToken());
            LocalDateTime myDate = LocalDateTime.ofInstant(tokenExpiredDate.toInstant(), ZoneId.systemDefault());

            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if(isAccessTokenExpired && myDate.isAfter(myDate.minusMinutes(2))) {
                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case

                final String accessToken = jwtUtil.doGenerateToken(  jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
                var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());

                return loginResponse;

            }
            else
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");

        }
        return new LoginResponse();
    }
}

