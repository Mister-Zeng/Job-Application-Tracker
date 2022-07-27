package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.User;

public interface AuthService {
    
    String loginUser(User appUser);
    
    User registerUser(User appUser);
}
