package com.aaulaundary.aau_laundary_system.Services;

import java.util.List;

import com.aaulaundary.aau_laundary_system.models.Clothe;

public interface ClotheServices {
    public Clothe saveClothe(Clothe clothe);
    public void updateClothe(String id, Clothe clothe);
    public Clothe findClothe(String id);
    public List<Clothe> findAllClothes();
    public void deleteClothe(String id);
    
}
