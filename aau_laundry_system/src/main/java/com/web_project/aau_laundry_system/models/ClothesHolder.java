package com.web_project.aau_laundry_system.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ClothesHolder {
    private List<Clothe> clothes;
    private String clothToBeDeleted;
    
}
