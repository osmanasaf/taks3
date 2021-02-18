package com.example.codefirst.task3.controller;

import com.example.codefirst.task3.UserAlreadyExistsException;
import com.example.codefirst.task3.UserData;

public interface UserService {
    void register(final UserData user) throws UserAlreadyExistException, UserAlreadyExistsException;

    boolean checkIfUserExist(final String username);

}
