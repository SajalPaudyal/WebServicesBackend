package com.miage.realestate.service.impl;

import com.miage.realestate.dto.LoginDto;
import com.miage.realestate.dto.RegisterDto;
import com.miage.realestate.entity.Role;
import com.miage.realestate.entity.User;
import com.miage.realestate.exceptions.ApiException;
import com.miage.realestate.repository.RoleRepository;
import com.miage.realestate.repository.UserRepository;
import com.miage.realestate.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    @Override
    public String register(RegisterDto registerDto) {

        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw  new ApiException(HttpStatus.BAD_REQUEST, "Username Already Exists");
        }

        if(userRepository.existsByEmail((registerDto.getEmail()))){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Email Already Exists");
        }

        User user  =  new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUserNameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User Logged-in Successfully";
    }
}
