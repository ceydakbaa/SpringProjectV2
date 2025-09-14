package com.example.ceyda.service.impl;



import com.example.ceyda.dto.request.UserRequest;
import com.example.ceyda.dto.response.UserResponse;
import com.example.ceyda.entity.User;
import com.example.ceyda.exception.UserNotFoundException;
import com.example.ceyda.repository.UserRepository;
import com.example.ceyda.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    private final ModelMapper modelMapper;

    public UserResponse createUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }
    public List<User> findUser(){
        return userRepository.findAll();
    }
    public User updateUser(User user){
        User updatedUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return userRepository.save(user);
    }
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("ID " + id + " için kullanıcı bulunamadı!"));
    }


}
