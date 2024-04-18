package com.miage.realestate.controller;

import com.miage.realestate.dto.LoginDto;
import com.miage.realestate.dto.RegisterDto;
import com.miage.realestate.entity.User;
import com.miage.realestate.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response  = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginDto){
        User response = authService.login(loginDto);

        //get user response
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
