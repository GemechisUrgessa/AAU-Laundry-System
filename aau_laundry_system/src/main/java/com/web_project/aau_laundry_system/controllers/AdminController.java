package com.web_project.aau_laundry_system.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.web_project.aau_laundry_system.Services.ClotheServices;
import com.web_project.aau_laundry_system.Services.LaundaryOrderServices;
import com.web_project.aau_laundry_system.Services.UserServices;
import com.web_project.aau_laundry_system.models.Clothe;
import com.web_project.aau_laundry_system.models.ClothesHolder;
import com.web_project.aau_laundry_system.models.LaundaryOrder;
import com.web_project.aau_laundry_system.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    LaundaryOrderServices laundaryOrderServices;
    @Autowired
    UserServices userServices;
    @Autowired
   ClotheServices clotheServices;


    @GetMapping("/admin")
    public String showAdminPage(Model model){
        ClothesHolder holder = new ClothesHolder();
        Clothe newClothe = new Clothe();
         List<LaundaryOrder> orders =laundaryOrderServices.findbByRecentOrders();
         List<User> users= userServices.findAllUser();
         List<Clothe> clothes=clotheServices.findAllClothes();
         holder.setClothes(clothes);
         int size=users.size();
         int totalOrders = laundaryOrderServices.findOrderCount();
         float totalEarning = laundaryOrderServices.findTotalEarning();
         String toBeDeleted="";

         model.addAttribute("totalUsers", size);
         model.addAttribute("orders", orders);
         model.addAttribute("newCloth", newClothe);
         model.addAttribute("clothes", clothes);
         model.addAttribute("totalOrders", totalOrders);
         model.addAttribute("delete", toBeDeleted);
         model.addAttribute("totalEarning", totalEarning);
         model.addAttribute("holder", holder);
         

        return "admin";
    }

    @GetMapping("/orderDashBoard")
    public String showorderDashBoard(Model model){
       List<LaundaryOrder> orders = laundaryOrderServices.findAllOrder();
       int size=orders.size();
       model.addAttribute("totalSize",size);
       model.addAttribute("orders", orders);


        return "orderDashBoard";
    }
    @PostMapping("/cloth/update")
    public String updateCloth(@ModelAttribute("holder") ClothesHolder clothesHolder){
      List<Clothe> clothe = clothesHolder.getClothes();
      for (int i =0;i<clothe.size();i++){
        clotheServices.updateClothe(clothe.get(i).getCategory(),clothe.get(i));
      }
        return "redirect:/";
    }

    @PostMapping("/cloth/new")
    public String updateCloth(@ModelAttribute("newCloth") Clothe newCloth){
        clotheServices.saveClothe(newCloth);
        return "redirect:/";
    }
    @PostMapping("/cloth/delete")
    public String deleteClothe(@ModelAttribute ClothesHolder holder){
        clotheServices.deleteClothe(holder.getClothToBeDeleted());
        return "redirect:/";
    }
    
    
}
