package com.example.microservice.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqSendTest {
    /*注入RabbitTemplate*/
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @org.junit.Test
    public void testSend() {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, "boot.my_queue", "Hello World");
    }
}

