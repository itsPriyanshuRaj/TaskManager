package com.priyanshuRaj.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.priyanshuRaj.taskmanager.dto.userDTO;
import com.priyanshuRaj.taskmanager.model.User;
import com.priyanshuRaj.taskmanager.repository.userRepo;

@Service
public class userServiceImpl implements userService {
    
    @Autowired
    private userRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerUser(userDTO userDTO){

        if(userRepo.findByEmail(userDTO.getEmail()).isPresent()){
            throw new RuntimeException("Email already in use");
        }
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole("USER");
        user.setUsername(userDTO.getUsername());
        user.setActive(true);

        userRepo.save(user);
        return "User registered successfully!!";
    }
}
