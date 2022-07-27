package com.example.jobapplicationtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobapplicationtracker.entities.Application;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
