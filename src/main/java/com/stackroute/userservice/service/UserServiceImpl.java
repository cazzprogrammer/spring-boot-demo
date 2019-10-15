package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

//    @Override
//    public User updateUser(User user) {
//        User updateUser = userRepository.save(user);
//        return updateUser;
//    }

//    @Override
//    public User findById(int id) {
////        User userId = userRepository.findById();
//        return null;
//    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
