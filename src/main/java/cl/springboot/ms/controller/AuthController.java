package cl.springboot.ms.controller;

import cl.springboot.ms.dto.JWTAuthResponseDto;
import cl.springboot.ms.dto.LoginDto;
import cl.springboot.ms.dto.SignUpDto;
import cl.springboot.ms.service.UserAuthenticationService;
import cl.springboot.ms.service.impl.UserAuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    UserAuthenticationServiceImpl userAuthenticationService;

    @PostMapping("/signup")
    public JWTAuthResponseDto signup(@RequestBody SignUpDto request) {

        return userAuthenticationService.signUp(request);
    }

    @PostMapping("/signin")
    public JWTAuthResponseDto authenticateUser(@RequestBody LoginDto request){

        return userAuthenticationService.authenticateUser(request);
    }



}
