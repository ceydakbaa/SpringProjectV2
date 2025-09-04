package com.example.ceyda.controller;

import com.example.ceyda.entity.User;
import com.example.ceyda.repository.UserRepository;
import com.example.ceyda.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/list")
    public List<User> findAll(){
        return userService.findUser();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable(name = "id") Long id ,@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }

}

