package com.niit.project.rabbitmq;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }


    public void sendMessageToMq(UserDTO userDTO){
        System.out.println(">>>>>Sending RabbitMQ<<<<<<");
        rabbitTemplate.convertAndSend(directExchange.getName(),"user_routing",userDTO);
    }
}
