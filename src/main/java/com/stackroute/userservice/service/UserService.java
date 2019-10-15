package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

//    public User updateUser(User user);
//    public User findById(int id);

    public List<User> getAllUsers();


}
