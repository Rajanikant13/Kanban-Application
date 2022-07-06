package com.niit.notification.rabbitmq;


import com.niit.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
public class Consumer {

    @Autowired
    private NotificationService service;



    @RabbitListener(queues = "user_queue")
    public void getUserDTOFromRabbitMq(UserDTO userDTO) throws MessagingException, IOException {
        System.out.println(userDTO);
        service.sendMail(userDTO.getEmail(), "User Details are updated for "+userDTO.getName());
           }

}
