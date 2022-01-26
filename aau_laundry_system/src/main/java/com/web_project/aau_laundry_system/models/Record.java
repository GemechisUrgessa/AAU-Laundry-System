package com.web_project.aau_laundry_system.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Entity
@Setter
@Getter
public class Record {
    @Id
    private String id;
    private String name;
    public Record() {
    }
    public Record(String name) {
        this.name = name;
    }
    

    


    
}
