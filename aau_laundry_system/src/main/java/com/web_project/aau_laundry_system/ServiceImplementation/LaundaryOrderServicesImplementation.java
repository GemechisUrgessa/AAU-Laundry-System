package com.web_project.aau_laundry_system.ServiceImplementation;

import java.util.List;

import com.web_project.aau_laundry_system.Repositories.LaundaryOrderRepository;
import com.web_project.aau_laundry_system.Services.LaundaryOrderServices;
import com.web_project.aau_laundry_system.models.LaundaryOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaundaryOrderServicesImplementation implements LaundaryOrderServices {
    @Autowired
    private LaundaryOrderRepository laundaryOrderRepository;

    @Override
    public LaundaryOrder saveLaundarOrder(LaundaryOrder laundaryOrder) {
        return laundaryOrderRepository.save(laundaryOrder);
    }

    @Override
    public LaundaryOrder findOrder(Long id) {
        if (laundaryOrderRepository.existsById(id)){
            return laundaryOrderRepository.findById(id).get();
       }
       return null;
    }

    @Override
    public void updateOrder(Long id, LaundaryOrder laundaryOrder) {
        if (laundaryOrderRepository.existsById(id)){
            laundaryOrderRepository.save(laundaryOrder);
        }  
        
    }

    @Override
    public List<LaundaryOrder> findAllOrder() {
        return laundaryOrderRepository.findAll();
    
}

    @Override
    public List<LaundaryOrder> findOrderByUsername(String username) {
      
        return laundaryOrderRepository.findOrderByUserName(username);
    }

    @Override
    public List<LaundaryOrder> findbByRecentOrders (){
            return laundaryOrderRepository.findbByRecentOrders();
    }

    @Override
    public int findOrderCount() {
         return laundaryOrderRepository.findOrderCount();
    
    }

    @Override
    public float findTotalEarning() {
        if(laundaryOrderRepository.findAll().size()>0){
            return laundaryOrderRepository.findTotalEarning();
        }
        else{
            return 0;
        }
        
    }

}

