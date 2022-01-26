package com.web_project.aau_laundry_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooterController {
    @GetMapping("/terms")
    public String toShow(){

        return "terms";
    }
    @GetMapping("/privacy")
    public String toDes(){

        return "privacy";
    }
    @GetMapping("/accessability")
    public String toFin(){

        return "accessablity";
    }
}
