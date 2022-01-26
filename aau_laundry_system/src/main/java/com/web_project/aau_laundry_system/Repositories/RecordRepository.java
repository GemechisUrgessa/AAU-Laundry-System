package com.web_project.aau_laundry_system.Repositories;

import com.web_project.aau_laundry_system.models.Record;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// @Repository
public interface RecordRepository extends JpaRepository<Record,String> {
    
}
