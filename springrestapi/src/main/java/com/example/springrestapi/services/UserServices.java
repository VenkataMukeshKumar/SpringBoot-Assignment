package com.example.springrestapi.services;

import com.example.springrestapi.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserServices
{
    public User createUser(User user);
    public List<User> getAllUsers();
    public Optional<User> getUserDetails(int id);
}