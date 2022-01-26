package com.web_project.aau_laundry_system.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.web_project.aau_laundry_system.Services.CampusService;
import com.web_project.aau_laundry_system.Services.ClotheServices;
import com.web_project.aau_laundry_system.Services.RecordService;
import com.web_project.aau_laundry_system.Services.UserServices;
import com.web_project.aau_laundry_system.models.Campus;
import com.web_project.aau_laundry_system.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    
   

    @Autowired
    private CampusService campusService;
    @Autowired
    private UserServices userServices;
    @Autowired
    private ClotheServices clotheServices;
    @Autowired
    private RecordService recordService;
    @Autowired
    private PasswordEncoder passwordEncoder;




@GetMapping("/")
public String home(Model model) {
    
    Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username;
    if (auth instanceof UserDetails) {
        username = ((UserDetails)auth).getUsername();
    } else {
        username = auth.toString();
    } 
    if(username.equals("anonymousUser")){
        model.addAttribute("status", "signedout");
    }
    else {
        User user = userServices.findUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("status", "loggedin");
        
    }


    return "home";
}
@GetMapping("*")
public String Error(Model model) {

    return "Error";
}

@GetMapping("/login")
public String login(Model model) {

    
    return "login";
}
@PostMapping("/loginFailled")
public String loginFailed(Model model) {
    model.addAttribute("message", "Error");
    return "login";
}

@GetMapping("/logout")
public String logout(Model model) {
    return "log-out";
}
    @GetMapping("/sign-up")
    public String signUP(Model model) {
        User student = new User();
        List<Campus> campus = campusService.getAllCampus();
        List <String> campusNames = new ArrayList<>();
        for (int i = 0;i<campus.size();i++){
            campusNames.add(campus.get(i).getName());
        }
        model.addAttribute("student", student);
        model.addAttribute("campuses", campusNames);
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String register(@Valid @ModelAttribute("student") User student,Errors errors, Model model){
        List<Campus> campus = campusService.getAllCampus();
        List <String> campusNames = new ArrayList<>();
        for (int i = 0;i<campus.size();i++){
            campusNames.add(campus.get(i).getName());
        }
        model.addAttribute("campuses", campusNames);
        if(errors.hasErrors()){
            return "sign-up";
        }

        String fullName = student.getFirstName().trim()+" "+student.getLastName().trim();
        String studentId = student.getUsername();
        String response = recordService.checkIfExists(studentId, fullName);
        boolean alreadyExists = userServices.findUser(student.getUsername())!=null;
        if(response.equals("NOT FOUND")){
            model.addAttribute("message", "NOT FOUND");
            return "sign-up";
        }
        else if(response.equals("ONLY ID FOUND")){
            model.addAttribute("message", "ONLY ID FOUND");
            return "sign-up";
        }
        else if(alreadyExists){
            model.addAttribute("message", "ALREADY EXISTS");
            return "sign-up";
        }
        else{
            student.setRole("USER");
            student.setPassword(passwordEncoder.encode(student.getPassword()));
            userServices.saveUser(student);
            model.addAttribute("message", "COMPLETE");
            return "sign-up";
        }
       
        
        
    }
    

    
    
    
}
