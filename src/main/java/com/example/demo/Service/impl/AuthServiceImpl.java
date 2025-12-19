package com.example.demo.Service.impl;

import com.example.demo.model.User;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.UserService;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserService userService;

    @Override
    public boolean changepassword(String oldpassword, String newpassword) {
        return false;
    }

    @Override
    public String login(String username, String password) {
        User user = userService.findByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            // throw new RuntimeException("login Failed");
            throw new BadCredentialsException("login fail");
        }
        if (!password.matches("^[A-Za-z\\d]{8,}$")) {
            throw new BadCredentialsException("Invalid  password");
            // throw new RuntimeException("Password must be at least 8 characters and contain only letters or digits");
        }

        return JwtUtil.generateToken(user);
    }
    //return user!=null&&user.getPassword().equals(password);

    @Override
    public String signup(String username,String email, String password) {
        // Check if the username is already taken
        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("Signup Failed: Username already exists");
        }

        // Validate password format
        if (!password.matches("^[A-Za-z\\d]{8,}$")) {
            throw new RuntimeException("Password must be at least 8 characters long and contain only letters or digits");
        }

        // Create a new user and save it in the database
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setRole( "USER");
        newUser.setPassword(password); // Ideally, encrypt the password before saving
        userService.add(newUser);

        // Optionally generate a token for the new user after signup
        return JwtUtil.generateToken(newUser);
    }

}