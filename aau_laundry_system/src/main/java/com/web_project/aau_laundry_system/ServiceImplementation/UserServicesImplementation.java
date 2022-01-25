package com.web_project.aau_laundry_system.ServiceImplementation;

import java.util.List;

import com.web_project.aau_laundry_system.Repositories.UserRepository;
import com.web_project.aau_laundry_system.Services.UserServices;
import com.web_project.aau_laundry_system.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServicesImplementation implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User student) {
        return userRepository.save(student);
    }

    @Override
    public void updateUser(String id, User student) {

        if (userRepository.existsById(id)){
            userRepository.save(student); 
        }  
    }

    @Override
    public User findUser(String id) {
        if (userRepository.existsById(id)){
             return userRepository.findById(id).get();
        }
        return null;
       
    }

   
    @Override
    public void deleteUser(String id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
      
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();
        
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
        
    }

    
}
