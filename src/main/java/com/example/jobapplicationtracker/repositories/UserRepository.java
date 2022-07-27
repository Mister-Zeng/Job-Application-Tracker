package com.example.jobapplicationtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jobapplicationtracker.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
