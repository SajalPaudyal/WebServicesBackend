package com.miage.realestate.service;

import com.miage.realestate.dto.LoginDto;
import com.miage.realestate.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
