package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.Role;
import com.example.jobapplicationtracker.entities.User;

import java.util.List;

public interface UserService {
    User getUser(String username);
    List<User> getUsers();
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
