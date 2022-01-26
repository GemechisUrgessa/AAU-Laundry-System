package com.web_project.aau_laundry_system.Services;

import java.util.List;

import com.web_project.aau_laundry_system.models.LaundaryOrder;

public interface LaundaryOrderServices {
    
    public LaundaryOrder saveLaundarOrder(LaundaryOrder clothe);
    public LaundaryOrder findOrder(Long id);
    public void updateOrder(Long id,LaundaryOrder laundaryOrder);
    public List<LaundaryOrder> findAllOrder();
    public List<LaundaryOrder> findOrderByUsername(String username);
    public List<LaundaryOrder> findbByRecentOrders ();
    public int findOrderCount();
    public float findTotalEarning();

}
