package com.priyanshuRaj.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.priyanshuRaj.taskmanager.dto.loginDTO;
import com.priyanshuRaj.taskmanager.model.User;
import com.priyanshuRaj.taskmanager.repository.userRepo;
import com.priyanshuRaj.taskmanager.security.JWTUtil;

@Service
public class authServiceImpl implements authService{
    
    @Autowired
    private userRepo userRepo;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String loginUser(loginDTO loginDTO){
        User user = userRepo.findByEmail(loginDTO.getEmail()).orElseThrow(()-> new RuntimeException("Email or password not found !!!"));

        if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid email or password !!!");
        }
        return jwtUtil.generateToken(user.getEmail());
    }
}
