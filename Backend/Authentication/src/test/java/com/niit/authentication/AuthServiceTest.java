package com.niit.authentication;


import com.niit.authentication.exception.UserNotFoundException;
import com.niit.authentication.model.User;
import com.niit.authentication.repository.AuthRepo;
import com.niit.authentication.service.UserAuthServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private UserAuthServiceImpl authService;
    @Autowired
    private AuthRepo repo;

    private User user;


    @BeforeEach
    public  void setAttributes(){
        user=new User(1,"mailmailmail","qweqweqwe","00000");

    }

    @AfterEach
    public void refreshAttributes(){
        user=null;
    }

    @Test
    public  void addUser(){
        User subject = authService.addUser(user);
        assertEquals(user.getPassword(),subject.getPassword());

    }

    @Test
    public void authUser() throws UserNotFoundException {
        User subject = authService.authenticateUser("mailmailmail","qweqweqwe");
    }



}
