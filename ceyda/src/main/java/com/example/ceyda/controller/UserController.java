package com.example.ceyda.controller;

import com.example.ceyda.dto.request.UserRequest;
import com.example.ceyda.dto.response.UserResponse;
import com.example.ceyda.entity.User;
import com.example.ceyda.exception.UserNotFoundException;
import com.example.ceyda.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userService.createUser(user);
        UserResponse userResponse = modelMapper.map(savedUser, UserResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
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
        User user= new User(1L,"ceyda","kaba","ceyda@gmail.com","1234");
        return modelMapper.map(user,UserResponse.class);
    }

}
