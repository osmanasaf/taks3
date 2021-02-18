package com.example.codefirst.task3.controller;

import com.example.codefirst.task3.User;
import com.example.codefirst.task3.UserAlreadyExistsException;
import com.example.codefirst.task3.UserData;
import com.example.codefirst.task3.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserController implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void register(UserData user) throws UserAlreadyExistsException {
        if (checkIfUserExist(user.getUsername())) {
            throw new UserAlreadyExistsException("User Already exist!");
        }
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);

    }

    @Override
    public boolean checkIfUserExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    private void encodePassword(User userEntity, UserData user) {
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
