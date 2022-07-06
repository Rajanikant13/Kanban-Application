package com.niit.authentication.controller;


import com.niit.authentication.exception.UserNotFoundException;
import com.niit.authentication.model.User;
import com.niit.authentication.service.TokenGenerator;
import com.niit.authentication.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@CrossOrigin("*")
@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private UserAuthService service;
    @Autowired
    private TokenGenerator tokenGenerator;


    @PostMapping("/register")
    public ResponseEntity<?>regUser(@RequestBody User user){
        System.out.println("User Auth Controller"+user);
        String status=null;
        User return_it=null;
        if (service.isEmailUnique(user)){
            return_it=service.addUser(user);
            status="Accepted";

        }else {
            status="Email already exist!!!";
        }
        System.out.println(status);
        return new ResponseEntity<>(return_it, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String,String>map=null;

        try {
            User subject=service.authenticateUser(user.getEmail(),user.getPassword());
            System.out.println("subject>>>>>"+subject);
            if (subject.getPassword().equalsIgnoreCase(user.getPassword())) {

                System.out.println("))))))subjectMatched");
                map = tokenGenerator.generate(subject);
            }

                return new ResponseEntity<>(map,HttpStatus.OK);


        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();

        }  catch (Exception e){
        return new ResponseEntity<>("Other Exception",HttpStatus.OK);

    }
    }

}
