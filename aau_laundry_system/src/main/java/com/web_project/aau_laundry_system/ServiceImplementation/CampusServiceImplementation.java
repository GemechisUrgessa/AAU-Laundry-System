package com.web_project.aau_laundry_system.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import com.web_project.aau_laundry_system.Repositories.CampusRepository;
import com.web_project.aau_laundry_system.Services.CampusService;
import com.web_project.aau_laundry_system.models.Campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampusServiceImplementation implements CampusService {

    @Autowired
    private CampusRepository campusRepository;

    @Override
    public List<Campus> getAllCampus() {
        return campusRepository.findAll();
    }

    @Override
    public Campus findCampusByName(String name) {
        Optional<Campus> result = campusRepository.findById(name);
        Campus newCampus;
        if (result.isPresent()) {
            newCampus = result.get();
        } else {
            throw new RuntimeException("The name you have enterd" + name + "Doesnot exist");
        }
        return newCampus;
    }

    @Override
    public void updateCamppusByName(String name) {
        CampusRepository.save(name);

    }

    @Override
    public void deleteCampusByName(String name) {
        campusRepository.deleteById(name);
    }

}
