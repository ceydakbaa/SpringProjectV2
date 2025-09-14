package com.example.ceyda.service.impl;

import com.example.ceyda.dto.auth.RegisterRequest;
import com.example.ceyda.dto.auth.RegisterResponse;
import com.example.ceyda.dto.request.UserRequest;
import com.example.ceyda.entity.User;
import com.example.ceyda.jwt.jwtService;
import com.example.ceyda.repository.UserRepository;
import com.example.ceyda.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


        private final UserRepository userRepository;
        private final ModelMapper modelMapper;
        private final PasswordEncoder passwordEncoder;
        private final jwtService jwtService;

    public RegisterResponse register(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userRepository.save(user);

        // RegisterResponse oluştur
        RegisterResponse response = new RegisterResponse();
        return response;
    }
    }
