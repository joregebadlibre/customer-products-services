package com.prueba.customer_products_services.controller;

import com.prueba.customer_products_services.service.MessageProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public String sendMessage() {
        rabbitTemplate.convertAndSend("myQueue", "Hello from Producer!");
        return "Message sent!";
    }
}