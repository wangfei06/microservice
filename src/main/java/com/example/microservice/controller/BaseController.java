package com.example.microservice.controller;

import com.example.microservice.sensitive.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseController")
public class BaseController {
    @RequestMapping("/query")
    public Person query(){
        Person person = new Person();
        person.setAddress("北京市朝阳区建国门外大街21号");
        person.setIdCard("37132719870504225X");
        person.setPhoneNumber("13810037586");
        person.setRealName("王飞");
        return person;
    }
}
