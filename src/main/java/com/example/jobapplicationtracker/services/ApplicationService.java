package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.Application;
import com.example.jobapplicationtracker.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    public List<Application> getApplications(){
        return (List<Application>) this.applicationRepository.findAll();
    }

    public Application addApplication(Application application){
        return this.applicationRepository.save(application);
    }

    public Application deleteApplication(Long applicationId){
        Optional<Application> applicationToDeleteOptional = this.applicationRepository.findById(applicationId);
        if(!applicationToDeleteOptional.isPresent()){
            return null;
        }
        Application applicationToDelete = applicationToDeleteOptional.get();
        this.applicationRepository.delete(applicationToDelete);
        return applicationToDelete;
    }

    public Application updateApplication(Long applicationId, Application application){
        Optional<Application> applicationToUpdateOptional = this.applicationRepository.findById(applicationId);
        if(!applicationToUpdateOptional.isPresent()){
            return null;
        }

        Application applicationToUpdate = applicationToUpdateOptional.get();

        if(application.getCompanyName() != null){
            applicationToUpdate.setCompanyName(application.getCompanyName());
        }
        if(application.getPosition() != null){
            applicationToUpdate.setPosition(application.getPosition());
        }
        if(application.getLocation() != null){
            applicationToUpdate.setLocation(application.getLocation());
        }
        if(application.getJobType() != null){
            applicationToUpdate.setJobType(application.getJobType());
        }
        if(application.getApplicationStatus() != null){
            applicationToUpdate.setApplicationStatus(application.getApplicationStatus());
        }

        Application updatedApplication = this.applicationRepository.save(applicationToUpdate);
        return updatedApplication;
    }
}
