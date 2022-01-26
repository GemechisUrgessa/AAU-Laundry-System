package com.web_project.aau_laundry_system.Services;
import java.util.List;

import com.web_project.aau_laundry_system.models.Campus;

public interface CampusService {

    public List<Campus> getAllCampus();
    public void addCampus(Campus campus);
    public Campus findCampusByName(String name);
    public void updateCamppusByName(String name);
    public void deleteCampusByName(String name);
    
}
