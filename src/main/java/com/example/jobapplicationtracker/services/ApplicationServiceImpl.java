package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.Application;
import com.example.jobapplicationtracker.repositories.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public Application getApplication(Long applicationId) {
        log.info("Fetching application {}", applicationId);
        return applicationRepository.findById(applicationId).orElse(null);
    }


    @Override
    public Application addApplication(Application application){
        log.info("Adding new application {} {} to the database.", application.getApplicationId(), application.getCompanyName());

        return this.applicationRepository.save(application);
    }

    @Override
    public Application deleteApplication(Long applicationId){
        log.info("Deleting application with id {}", applicationId);
        Optional<Application> applicationToDeleteOptional = this.applicationRepository.findById(applicationId);
        if(applicationToDeleteOptional.isEmpty()){
            return null;
        }
        Application applicationToDelete = applicationToDeleteOptional.get();
        this.applicationRepository.delete(applicationToDelete);
        return applicationToDelete;
    }

    @Override
    public Application updateApplication(Long applicationId, Application application){
        log.info("Updating application {} {} to the database.", application.getApplicationId(), application.getCompanyName());
        Optional<Application> applicationToUpdateOptional = this.applicationRepository.findById(applicationId);
        if(applicationToUpdateOptional.isEmpty()){
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

        return this.applicationRepository.save(applicationToUpdate);
    }
}
