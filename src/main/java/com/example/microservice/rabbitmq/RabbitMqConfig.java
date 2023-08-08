package com.example.microservice.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    /*定义交换机名称*/
    public static final String EXCHANGE_NAME = "boot_topic_exchange";
    /*定义队列名称*/
    public static final String QUEUE_NAME = "boot_queue";

    /*交换机*/
    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    /* 2.Queue 队列*/
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    /**队列和交换机绑定关系*/
    @Bean
    public Binding getBinding(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }
}
