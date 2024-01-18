package com.Certif.SlackLike.service;

import com.Certif.SlackLike.model.User;
import com.Certif.SlackLike.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // getAllUsers
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // getUserById
    public Optional<User> getUserById(Integer id) {

        return userRepository.findById(id);
    }

    //createUser
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //updateUser
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //deleteUser
    public boolean deleteUser(Integer id) {
        if (getUserById(id).isEmpty())
            return false;
        else {
            userRepository.deleteById(id);
            return true;
        }


    }
}
