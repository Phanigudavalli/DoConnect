package com.doconnect.service;

import java.util.Optional;

import com.doconnect.model.User;

public interface UserService {
    User register(User user);
    User login(String username, String password);
    User getUserById(Long id);
    void deactivateUser(Long id);
    void saveUser(User user);
}

