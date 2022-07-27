package com.example.jobapplicationtracker;

import com.example.jobapplicationtracker.entities.Role;
import com.example.jobapplicationtracker.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobApplicationTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplicationTrackerApplication.class, args);
    }

    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
        };
    }

}


