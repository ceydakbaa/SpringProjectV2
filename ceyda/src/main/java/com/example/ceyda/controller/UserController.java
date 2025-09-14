package com.example.ceyda.controller;

import com.example.ceyda.dto.auth.RegisterResponse;
import com.example.ceyda.dto.request.UserRequest;
import com.example.ceyda.dto.response.UserResponse;
import com.example.ceyda.entity.User;
import com.example.ceyda.exception.UserNotFoundException;
import com.example.ceyda.service.AuthService;
import com.example.ceyda.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final AuthService authService;

    @PostMapping("/save")
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        logger.info("User created");
        return userService.createUser(userRequest);
    }
   @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody UserRequest userRequest) {
        logger.info("User registered");
        RegisterResponse response = authService.register(userRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<User> findAll(){
        return userService.findUser();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable(name = "id") Long id , @RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable(name = "id") Long id) {
        if (id != 1) {
            throw new UserNotFoundException("ID " + id + " için kullanıcı bulunamadı!");
        }
        User user= new User();
        return modelMapper.map(user,UserResponse.class);
    }

}
