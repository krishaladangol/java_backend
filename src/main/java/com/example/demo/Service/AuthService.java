package com.example.demo.Service;

public interface AuthService {
    boolean changepassword(String oldpassword, String newpassword);

    String login(String username, String password);
    String signup(String username,String email, String password);
}