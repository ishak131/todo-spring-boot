package com.asset.todo.service;

import com.asset.todo.model.UserModel;
import com.asset.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(UserModel userModel) {
        userRepository.save(userModel);
    }

    public UserModel login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}
