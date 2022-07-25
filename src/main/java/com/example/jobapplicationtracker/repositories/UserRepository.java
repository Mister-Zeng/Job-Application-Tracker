package com.example.jobapplicationtracker.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.jobapplicationtracker.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
