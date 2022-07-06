package com.niit.project.service;

import com.niit.project.exception.NotFoundException;
import com.niit.project.model.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);
    public List<User> getAllUser();
    public boolean delUser(String name) throws NotFoundException;
    public User getUser(String email);
//    public UserDTO notifyUser(User user);
}
