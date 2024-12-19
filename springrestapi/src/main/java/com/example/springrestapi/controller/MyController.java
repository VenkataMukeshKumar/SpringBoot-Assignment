package com.example.springrestapi.controller;

import com.example.springrestapi.entities.User;
import com.example.springrestapi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController
{
    @Autowired
    private UserServices userServices;
    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user)
    {
        return userServices.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUserDetails()
    {
        return userServices.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable int id)
    {
        User user = userServices.getUserDetails(id).orElse(null);
        if(user != null)
        {
            return ResponseEntity.ok().body(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
