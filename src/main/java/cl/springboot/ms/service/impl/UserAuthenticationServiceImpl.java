package cl.springboot.ms.service.impl;

import cl.springboot.ms.domain.Role;
import cl.springboot.ms.dto.LoginDto;
import cl.springboot.ms.dto.SignUpDto;
import cl.springboot.ms.repository.UserAuthenticationRepository;
import cl.springboot.ms.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import cl.springboot.ms.domain.UserAuthentication;
import cl.springboot.ms.dto.JWTAuthResponseDto;
import cl.springboot.ms.service.UserAuthenticationService;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserAuthenticationServiceImpl {

    private AuthenticationManager authenticationManager;

    private JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder;

    private UserAuthenticationRepository userAuthenticationRepository;

    //@Override
    public JWTAuthResponseDto signUp(SignUpDto request) {

        UserAuthentication user = new UserAuthentication();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userAuthenticationRepository.save(user);

        String jwt = jwtProvider.generateToken(user);

        return JWTAuthResponseDto.builder().tokenDeAcceso(jwt).build();
    }

   //@Override
    public JWTAuthResponseDto authenticateUser(LoginDto request) {

        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserAuthentication user = userAuthenticationRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        String jwt = jwtProvider.generateToken(user);

        return JWTAuthResponseDto.builder().tokenDeAcceso(jwt).build();
    }
}
