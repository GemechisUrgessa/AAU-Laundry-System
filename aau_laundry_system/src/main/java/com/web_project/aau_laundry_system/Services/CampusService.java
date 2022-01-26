package com.aaulaundary.aau_laundary_system.Services;
import java.util.List;

import com.aaulaundary.aau_laundary_system.models.Campus;

public interface CampusService {

    public List<Campus> getAllCampus();
    public void addCampus(Campus campus);
    public Campus findCampusByName(String name);
    public void updateCamppusByName(String name);
    public void deleteCampusByName(String name);
    
}
