package com.example.jobapplicationtracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.jobapplicationtracker.entities.Application;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
