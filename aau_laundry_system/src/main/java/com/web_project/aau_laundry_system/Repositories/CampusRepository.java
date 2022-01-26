package com.aaulaundary.aau_laundary_system.Repositories;

import com.aaulaundary.aau_laundary_system.models.Campus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus, String>  {

    static void save(String name) {
    }
    
}
