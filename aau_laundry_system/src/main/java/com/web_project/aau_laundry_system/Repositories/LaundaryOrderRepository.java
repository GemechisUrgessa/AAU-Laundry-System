package com.aaulaundary.aau_laundary_system.Repositories;

import java.util.List;

import com.aaulaundary.aau_laundary_system.models.LaundaryOrder;

// import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scripting.config.LangNamespaceHandler;

public interface LaundaryOrderRepository extends JpaRepository<LaundaryOrder,Long>   {
    @Query(value = "select * from laundary_order where user_username = ?1",nativeQuery = true)
    public List<LaundaryOrder> findOrderByUserName(String username);
    @Query(value = "select * from laundary_order limit 6",nativeQuery = true)
    public List<LaundaryOrder> findbByRecentOrders ();
    @Query(value = "select count(*)from laundary_order",nativeQuery = true)
    public int findOrderCount();
    @Query(value = "select sum(payment_amount)from laundary_order",nativeQuery = true)
    public float findTotalEarning();

    
}
