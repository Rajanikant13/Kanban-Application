package com.niit.notification.controller;

import com.niit.notification.model.UserDetails;
import com.niit.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/message")
public class NoteController {
    @Autowired
    private NotificationService service;
    private UserDetails details;




    @RequestMapping("/send")
    public String sendIt(@RequestParam String email,@RequestParam String message) throws MessagingException, IOException {
        service.sendMail(email,message);
//        details.setName("asdasdasd");
//        details.setMessage("asdasdasdmessage");
        return "sent";
    }
}
