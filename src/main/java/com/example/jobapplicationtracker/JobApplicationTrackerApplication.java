package com.example.jobapplicationtracker;

import com.example.jobapplicationtracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobApplicationTrackerApplication {


    @Autowired
    UserService userService;

//    @PostConstruct
//    public void UserInit() {
//        User users = new User(null, "Jake Bonds", "jakebonds", "jakebonds@gmail.com", "testing123");
//
//        userService.saveUser(users);
//    }

    public static void main(String[] args) {
        SpringApplication.run(JobApplicationTrackerApplication.class, args);
    }

}


