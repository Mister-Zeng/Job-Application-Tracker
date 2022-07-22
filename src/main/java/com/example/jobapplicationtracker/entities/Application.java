package com.example.jobapplicationtracker.entities;

import javax.persistence.*;

@Entity
@Table(name = "APPLICATIONS")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    private String companyName;
    private String position;
    private String location;
    private String jobType;
    private String applicationStatus;

    public Application(String companyName, String position, String location, String jobType, String applicationStatus) {
        this.companyName = companyName;
        this.position = position;
        this.location = location;
        this.jobType = jobType;
        this.applicationStatus = applicationStatus;
    }

    public Application() {

    }

    public Long getId() {
        return applicationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }

    public String getLocation() {
        return location;
    }

    public String getJobType() {
        return jobType;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setId(Long id) {
        this.applicationId = applicationId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

}
