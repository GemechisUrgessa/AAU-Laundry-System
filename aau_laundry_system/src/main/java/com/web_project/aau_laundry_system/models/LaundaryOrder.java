package com.aaulaundary.aau_laundary_system.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class LaundaryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    private String date;
    private float paymentAmount;
    private String doormBlockNumber;
    public LaundaryOrder(String date, float paymentAmount, String doormBlockNumber, String doormNumber,
            String deliveryTime, int quantity) {
        this.date = date;
        this.paymentAmount = paymentAmount;
        this.doormBlockNumber = doormBlockNumber;
        this.doormNumber = doormNumber;
        this.deliveryTime = deliveryTime;
        this.quantity = quantity;
    }
    private String doormNumber;
    private String deliveryTime;
    private int quantity;

   
    
}
