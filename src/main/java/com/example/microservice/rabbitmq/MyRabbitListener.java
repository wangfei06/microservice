package com.example.microservice.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {
    @RabbitListener(queues = "boot_queue")
    public void myListener(String message){
        System.out.println("消费者接收到的消息为：" + message);
    }
}
