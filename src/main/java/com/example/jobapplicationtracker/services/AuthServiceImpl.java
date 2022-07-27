package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.User;
import com.example.jobapplicationtracker.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public String loginUser(User appUser) {
        String encodedPassword = this.passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        return null;
    }

    @Override
    public User registerUser(User appUser) {
        return null;
    }
}
