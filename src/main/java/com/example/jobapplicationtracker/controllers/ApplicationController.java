package com.example.jobapplicationtracker.controllers;

import com.example.jobapplicationtracker.entities.Application;
import com.example.jobapplicationtracker.services.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

    @Autowired
    ApplicationService service;

    @GetMapping("/applications")
    public List<Application> getAllApplications(){
        return service.getApplications();
    }

}
