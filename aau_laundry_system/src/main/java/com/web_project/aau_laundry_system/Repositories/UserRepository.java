package com.web_project.aau_laundry_system.Repositories;

import com.web_project.aau_laundry_system.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUsername(String username);
    
}
