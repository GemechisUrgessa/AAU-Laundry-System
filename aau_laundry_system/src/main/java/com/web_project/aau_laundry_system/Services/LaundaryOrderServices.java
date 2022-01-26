package com.aaulaundary.aau_laundary_system.Services;

import java.util.List;

import com.aaulaundary.aau_laundary_system.models.LaundaryOrder;
import com.aaulaundary.aau_laundary_system.models.User;

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
