package com.web_project.aau_laundry_system.Services;

import java.util.List;

import com.web_project.aau_laundry_system.models.Clothe;

public interface ClotheServices {
    public Clothe saveClothe(Clothe clothe);
    public void updateClothe(String id, Clothe clothe);
    public Clothe findClothe(String id);
    public List<Clothe> findAllClothes();
    public void deleteClothe(String id);
    
}
