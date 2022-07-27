package com.example.jobapplicationtracker.services;

import com.example.jobapplicationtracker.entities.User;
import com.example.jobapplicationtracker.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getApplications().forEach(application -> authorities.add(new SimpleGrantedAuthority(application.getApplicationId().toString())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}.", username);
        return this.userRepository.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users.");
        return this.userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        log.info("User {} is saved to the database", user);
        return this.userRepository.save(user);
    }

}
