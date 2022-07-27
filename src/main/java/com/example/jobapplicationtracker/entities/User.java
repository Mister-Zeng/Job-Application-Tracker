package com.example.jobapplicationtracker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String username;
    private String email;
    private String password;
    @ManyToMany(fetch = EAGER)
    private ArrayList<Application> applications = new ArrayList<>();
}
