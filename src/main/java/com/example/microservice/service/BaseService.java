package com.example.microservice.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    public String getName(){
        ApplicationContext context = null;
        return "wangfei";
    }
}
