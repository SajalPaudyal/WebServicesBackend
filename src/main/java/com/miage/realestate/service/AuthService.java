package com.miage.realestate.service;

import com.miage.realestate.dto.LoginDto;
import com.miage.realestate.dto.RegisterDto;
import com.miage.realestate.entity.User;

public interface AuthService {
    String register(RegisterDto registerDto);

    User login(LoginDto loginDto);
}
