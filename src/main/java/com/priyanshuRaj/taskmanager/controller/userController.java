package com.priyanshuRaj.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshuRaj.taskmanager.dto.userDTO;
import com.priyanshuRaj.taskmanager.service.userService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class userController {
    
    @Autowired
    private userService userService;

    @PostMapping("/register")
    public ResponseEntity<String> regitserUser(@Valid @RequestBody userDTO userDTO){
        String result = userService.registerUser(userDTO);
        return ResponseEntity.ok(result);
    }
}
