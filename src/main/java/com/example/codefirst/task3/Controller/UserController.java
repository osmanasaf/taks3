package com.example.codefirst.task3.Controller;

import com.example.codefirst.task3.Repository.UserRepository;
import com.example.codefirst.task3.Role;
import com.example.codefirst.task3.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

    }

    public User findUser(String username) {
        return userRepository.getOne(username);
    }

    public boolean isUserHere(String username) {
        User before = userRepository.getOne(username);
        if (before != null)
            return true;
        return false;
    }
}
