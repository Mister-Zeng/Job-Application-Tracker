package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.Application;

public interface ApplicationService {
    Application getApplication(Long applicationId);

    Application addApplication(Application application);

    Application deleteApplication(Long applicationId);
    Application updateApplication(Long applicationId, Application application);

}
