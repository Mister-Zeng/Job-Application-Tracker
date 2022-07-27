package com.example.jobapplicationtracker.controllers;

import com.example.jobapplicationtracker.entities.Application;
import com.example.jobapplicationtracker.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @GetMapping("/{applicationId}")
    public ResponseEntity<Application> getApplication(@PathVariable Long applicationId) {
        return ResponseEntity.ok(this.applicationService.getApplication(applicationId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Application>> getUserApplications(@RequestBody String username){
        return ResponseEntity.ok().body(this.applicationService.getUserApplications(username));
    }

    @PostMapping("/newApplication")
    public ResponseEntity<Application> addNewApplication(@RequestBody Application application, String username){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/application/add").toUriString());
        return ResponseEntity.created(uri).body(this.applicationService.addApplication(application, username));
    }

    @DeleteMapping("/deleteApplication/{applicationId}")
    public ResponseEntity<Application> deleteApplication(@PathVariable("applicationId") Long applicationId) {
        Application applicationToDelete = applicationService.deleteApplication(applicationId);
        return new ResponseEntity<>(applicationToDelete, HttpStatus.OK);
    }

    @PutMapping("/updateApplication/{applicationId}")
    public ResponseEntity<Application> updateApplication(
            @PathVariable("applicationId") Long applicationId,
            @RequestBody Application application){
        this.applicationService.updateApplication(applicationId, application);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
