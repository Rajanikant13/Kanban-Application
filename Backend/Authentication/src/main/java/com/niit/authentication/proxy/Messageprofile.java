package com.niit.authentication.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "message",url = "localhost:9090")
public interface Messageprofile {

    @PostMapping("/message/send")
    public String sendDetails(@RequestParam String email, @RequestParam String message);
}
