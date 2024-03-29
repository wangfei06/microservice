package com.example.microservice.mq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    static final String QUEUE_NAME = "my_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.0.107");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,true,false,false,null);

        String message = "Sunny day";
        //交换机：不存在没有交换机的队列，不指定的情况下会默认指定一个交换机AMQP_DEFAULT交换机
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("消息已发送：+ " + message);

        channel.close();
        connection.close();
    }
}
