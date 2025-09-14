package com.example.ceyda.service;

import com.example.ceyda.dto.request.UserRequest;
import com.example.ceyda.dto.response.UserResponse;
import com.example.ceyda.entity.User;

import java.util.List;

public interface UserService {

    public UserResponse createUser(UserRequest userRequest);
    public List<User> findUser();
    public User updateUser(User user);
    public void deleteUser(long id);
    public User getUserById(Long id);
}
