package com.web_project.aau_laundry_system.Repositories;

import com.web_project.aau_laundry_system.models.Campus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus, String>  {

    static void save(String name) {
    }
    
}
