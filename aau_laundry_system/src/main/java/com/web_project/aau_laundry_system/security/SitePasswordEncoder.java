package com.aaulaundary.aau_laundary_system.Security;

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
