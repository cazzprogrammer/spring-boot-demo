package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        ResponseEntity responseEntity ;
        try {
            userService.saveUser(user);
            responseEntity = new ResponseEntity<String>("Successfull created", HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("user")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<?> searchByid(@PathVariable(value = "id") int id){
        return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping("user")
    public ResponseEntity<?> updateinfo(@RequestBody User user)
    {
        ResponseEntity responseEntity ;
        try {
            userService.updateUser(user);
            responseEntity = new ResponseEntity<String>("updated successfull", HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;


    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int id)
    {
        ResponseEntity responseEntity ;
        try {
            userService.deleteUser(id);
            responseEntity = new ResponseEntity<String>("deleted successfull", HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;


    }

}
