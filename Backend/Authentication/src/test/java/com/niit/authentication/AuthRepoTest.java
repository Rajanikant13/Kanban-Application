package com.niit.authentication;


import com.niit.authentication.model.User;
import com.niit.authentication.repository.AuthRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthRepoTest {
    @Autowired
    private AuthRepo repo;

    private User user;


    @BeforeEach
    public void setAttributes(){
        user=new User(1,"zxczxc","qweqwe","00000");

    }

    @AfterEach
    public void refreshAtttributes(){
        user=null;
        repo.deleteAll();
    }

    @Test
    public void addUser(){
        User subject=repo.save(user);
        assertEquals(user.getEmail(),subject.getEmail());
    }


//    @Test
//    public void getByEmailPassword(){
//        User subject = repo.findByEmailAndPassword("zxczxc","qweqwe");
//        assertEquals(user.getPassword(),subject.getPassword());
//    }

}
