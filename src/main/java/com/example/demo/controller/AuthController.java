package com.example.demo.controller;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.SignupDto;
import com.example.demo.model.User;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public Map<String,String> login (@RequestBody LoginDto loginDto){
        String token  = authService.login(loginDto.username(),loginDto.password());
        return Map.of("Token",token);
    }
    @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody SignupDto signupDto) {
        authService.signup(signupDto.username(),signupDto.email(), signupDto.password());
        return Map.of("Message", "User registered successfully");
    }


   /* @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody SignupDto signupDto) {
        String token = authService.signup(signupDto.username(), signupDto.password());
        return Map.of("Token", token);
    }*/
}