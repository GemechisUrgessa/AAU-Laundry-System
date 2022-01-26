package com.web_project.aau_laundry_system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SitePasswordEncoder {
    @Bean
    PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
