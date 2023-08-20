package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User user = new User(username,password);
        userRepository3.save(user);
        return user;
    }

    public void deleteUser(int userId) throws Exception {
            Optional<User> userOptional = userRepository3.findById(userId);
            if(!userOptional.isPresent()) throw new Exception("Invalid Id");
        User user = userOptional.get();
        userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password) throws Exception {
        Optional<User> userOptional = userRepository3.findById(id);
        if(!userOptional.isPresent()) throw new Exception("Invalid Id");
        User user = userOptional.get();
        user.setPassword(password);
        return user;
    }
}
