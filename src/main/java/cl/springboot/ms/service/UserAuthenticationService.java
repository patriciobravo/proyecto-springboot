package cl.springboot.ms.service;

import cl.springboot.ms.dto.JWTAuthResponseDto;
import cl.springboot.ms.dto.LoginDto;
import cl.springboot.ms.dto.SignUpDto;

public interface UserAuthenticationService {

    JWTAuthResponseDto signUp(SignUpDto request);

    JWTAuthResponseDto authenticateUser(LoginDto request);
}
