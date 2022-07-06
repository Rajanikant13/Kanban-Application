package com.niit.project.controller;

import com.niit.project.exception.AlreadyExistException;
import com.niit.project.exception.EmptyProjectException;
import com.niit.project.exception.NotFoundException;
import com.niit.project.exception.StageNotFoundException;
import com.niit.project.model.User;
import com.niit.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService service;

    @GetMapping("/extract-user")
    public ResponseEntity<?> extractUser() throws EmptyProjectException {
        return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
    }
    //6655/user/get
    @GetMapping("/get/{email}")
    public ResponseEntity<?> getUser(@PathVariable String email)  {
        return new ResponseEntity<>(service.getUser(email), HttpStatus.OK);
    }

    @PostMapping("/insert-user")
    public ResponseEntity<?>insertUser(@RequestBody User user) throws EmptyProjectException, AlreadyExistException {
        return new ResponseEntity<>(service.addUser(user),HttpStatus.OK);
    }


    @DeleteMapping("/remove-stage/{name}")
    public ResponseEntity<?>removeStage(@PathVariable String name) throws StageNotFoundException, NotFoundException {
        return new ResponseEntity<>(service.delUser(name),HttpStatus.OK);
    }
}
