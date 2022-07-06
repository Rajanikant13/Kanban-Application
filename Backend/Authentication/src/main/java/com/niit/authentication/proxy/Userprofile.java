package com.niit.authentication.proxy;


import com.niit.authentication.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "userToMain",url = "localhost:6655")
public interface Userprofile {

    @PostMapping("/user/insert-user")
    public ResponseEntity<?> insertUser(@RequestBody User user);




}
