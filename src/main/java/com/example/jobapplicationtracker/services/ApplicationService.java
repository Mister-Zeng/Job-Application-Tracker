package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.Application;
import com.example.jobapplicationtracker.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    public List<Application> getApplications(){
        return (List<Application>) applicationRepository.findAll();
    }

}
