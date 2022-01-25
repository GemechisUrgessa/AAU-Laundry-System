package com.web_project.aau_laundry_system.Services;

import java.util.List;

import com.web_project.aau_laundry_system.models.User;




public interface UserServices {

    public User saveUser(User student);
    public void updateUser(String id, User student);
    public User findUser(String id);
    public void deleteUser(String id);
    public List<User> findAllUser();
    public void deleteAllUser();
    public User findUserByUsername(String username);

    
}
