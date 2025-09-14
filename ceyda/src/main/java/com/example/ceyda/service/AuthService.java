package com.example.ceyda.service;

import com.example.ceyda.dto.auth.RegisterRequest;
import com.example.ceyda.dto.auth.RegisterResponse;
import com.example.ceyda.dto.request.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {
RegisterResponse register(@Valid @RequestBody UserRequest userRequest);
}
