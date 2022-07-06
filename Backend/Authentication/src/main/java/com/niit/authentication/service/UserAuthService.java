package com.niit.authentication.service;

import com.niit.authentication.exception.UserNotFoundException;
import com.niit.authentication.model.User;

import java.util.List;

public interface UserAuthService {

    public abstract User addUser(User user);
    public abstract User authenticateUser(String email, String password) throws UserNotFoundException;
    public abstract boolean isEmailUnique(User user);
    public abstract List<User> getAllUsers();

}
