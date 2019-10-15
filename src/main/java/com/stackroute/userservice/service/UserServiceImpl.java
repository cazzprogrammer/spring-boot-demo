package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User updateUser(User user) {
       Optional<User> user1 = userRepository.findById(user.getId());

       User user2 = user1.get();
       user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
        user2.setAge(user.getAge());
        return userRepository.save(user2);

    }

    @Override
    public void deleteUser(int id) {
        Optional<User> user1 = userRepository.findById(id);
        User user2 = user1.get();
        userRepository.delete(user2);
    }


    @Override
    public User findById(int id) {
       Optional<User> userId = userRepository.findById(id);
        User user2 = userId.get();
        return user2;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
