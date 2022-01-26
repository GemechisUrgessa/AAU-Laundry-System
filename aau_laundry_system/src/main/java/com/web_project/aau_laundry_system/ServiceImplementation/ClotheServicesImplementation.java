package com.web_project.aau_laundry_system.ServiceImplementation;

import java.util.List;

import com.web_project.aau_laundry_system.Repositories.ClotheRepositiories;
import com.web_project.aau_laundry_system.Services.ClotheServices;
import com.web_project.aau_laundry_system.models.Clothe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClotheServicesImplementation implements ClotheServices {
    @Autowired
    ClotheRepositiories clotheRepositiories;

    @Override
    public Clothe saveClothe(Clothe clothe) {
        clothe.setCategory(clothe.getCategory().toUpperCase());
        return clotheRepositiories.save(clothe);
    }

    @Override
    public void updateClothe(String id, Clothe clothe) {
        if (clotheRepositiories.existsById(id)){
            clotheRepositiories.save(clothe);
        } 
        
    }

    @Override
    public Clothe findClothe(String id) {
        if (clotheRepositiories.existsById(id)){
            return clotheRepositiories.findById(id).get();
       }
       return null;
    }

    @Override
    public void deleteClothe(String id) {
        if(clotheRepositiories.existsById(id)){
            clotheRepositiories.deleteById(id);
        }
    }

    @Override
    public List<Clothe> findAllClothes() {
       return clotheRepositiories.findAll();
    }
    
}
