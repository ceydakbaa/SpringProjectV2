package com.example.ceyda.service;

import com.example.ceyda.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);
    public List<User> findUser();
    public User updateUser(User user);
    public void deleteUser(long id);
    public User getUserById(Long id);
}
