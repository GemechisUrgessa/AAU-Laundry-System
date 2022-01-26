package com.web_project.aau_laundry_system.controllers;

import java.net.http.WebSocket.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.validation.Valid;

import com.web_project.aau_laundry_system.Services.ClotheServices;
import com.web_project.aau_laundry_system.Services.LaundaryOrderServices;
import com.web_project.aau_laundry_system.Services.UserServices;
import com.web_project.aau_laundry_system.models.LaundaryOrder;
import com.web_project.aau_laundry_system.models.User;

@Controller
public class ProfileController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private ClotheServices clotheServices;
    @Autowired
    private LaundaryOrderServices laundaryOrderServices;
    @Autowired
    private PasswordEncoder passwordEncoder;
    

 
    @GetMapping("/profile")
    public String toShowProfile(Model themodel){
            
    Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username;
    if (auth instanceof UserDetails) {
        username = ((UserDetails)auth).getUsername();
    } else {
        username = auth.toString();
    } 
    if(username.equals("anonymousUser")){
        themodel.addAttribute("status", "signedout");
    }
    else {
        User user = userServices.findUserByUsername(username);
        themodel.addAttribute("user", user);
        themodel.addAttribute("status", "loggedin");
        
    }

       List<LaundaryOrder> order=  laundaryOrderServices.findAllOrder();


         User user= userServices.findUserByUsername(username);
         String userID=user.getUsername();

          themodel.addAttribute("user",user);
        
          List<LaundaryOrder> orders=laundaryOrderServices.findOrderByUsername(user.getUsername());
         themodel.addAttribute("order", orders);
        return "profile";
    }
    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute("user") User user){

        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (auth instanceof UserDetails) {
            username = ((UserDetails)auth).getUsername();
        } else {
            username = auth.toString();
        } 
 
        User existingUser= userServices.findUserByUsername(username);
        user.setUsername(existingUser.getUsername());
        user.setRole(existingUser.getRole());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
      String name = user.getPassword();
       String name2 = existingUser.getPassword();
        System.out.println(name.equals(name2));
        // if(user.getPassword().equals("")){
        //     user.setPassword(existingUser.getPassword());
        // }
        userServices.saveUser(user);
        
        return "redirect:/";

    }


    
}