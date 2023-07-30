package com.example.microservice.mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单模式
 */
public class Consumer {
    static final String QUEUE_NAME = "my_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.0.107");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("123456");

        Connection connection = null;
        Channel channel = null;
        try {
            //建立连接
            connection = connectionFactory.newConnection();
            //创建通道
            channel = connection.createChannel();

            channel.basicConsume(QUEUE_NAME, true, new DeliverCallback() {
                @Override
                public void handle(String consumerTag, Delivery message) throws IOException {
                    System.out.println("接收到的消息内容是：" + new String(message.getBody(),"utf-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String consumerTag) throws IOException {
                    System.out.println("接收消息失败");
                }
            });
            System.out.println("开始接收消息");
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
