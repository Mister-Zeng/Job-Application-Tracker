package com.example.jobapplicationtracker.entities;

import javax.persistence.*;

@Entity
@Table(name = "APPLICATIONS")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "JOB_TYPE")
    private String jobType;
    @Column(name = "APPLICATION_STATUS")
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

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", location='" + location + '\'' +
                ", jobType='" + jobType + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }
}
