package com.example.microservice.designpattern.observer;

public class WeatherDataDisplay implements Observer{
    private float temperature;

    private float pressure;

    private Subject subject;

    public WeatherDataDisplay(Subject subject){
        this.subject = subject;
        //注册观察者
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        display();
    }

    public void display(){
        System.out.println("Current weather data:" + temperature + "," + pressure);
    }
}
