package com.example.jobapplicationtracker.controllers;

import com.example.jobapplicationtracker.entities.Application;
import com.example.jobapplicationtracker.services.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/newApplication")
    public Application addNewApplication(@RequestBody Application application){
        return service.addApplication(application);
    }

    @DeleteMapping("/deleteApplication/{applicationId}")
    public Application deleteApplication(@PathVariable Long applicationId){
       return service.deleteApplication(applicationId);
    }

    @PutMapping("/updateApplication")
    public Application updateApplication(@PathVariable("applicationId") Long applicationId,
                                         @RequestBody Application application){
        return service.updateApplication(applicationId, application);
    }
}
