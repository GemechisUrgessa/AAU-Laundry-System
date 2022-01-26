package com.aaulaundary.aau_laundary_system.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Campus {
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Campus() {
    }

    public Campus(String name) {
        this.name = name;
    }
    
    
}
