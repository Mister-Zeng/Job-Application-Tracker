package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.Application;

import java.util.List;

public interface ApplicationService {
    Application getApplication(Long applicationId);
    List<Application> getUserApplications(String username);
    Application addApplication(Application application, String username);
    Application deleteApplication(Long applicationId);
    Application updateApplication(Long applicationId, Application application);

}
