package com.aaulaundary.aau_laundary_system.Security;

import com.aaulaundary.aau_laundary_system.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SiteUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByUsername(username);
        if (user==null) throw new UsernameNotFoundException("username can not be found");
        else{
            return user;
        }

    }
    
}
