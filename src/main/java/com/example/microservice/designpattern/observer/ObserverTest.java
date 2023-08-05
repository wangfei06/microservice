package com.example.microservice.designpattern.observer;

public  class ObserverTest {
    public static void main(String[] args) {
        //具体的主题
        WeatherData weatherData = new WeatherData();
        //具体的观察者/订阅者
        WeatherDataDisplay weatherDataDisplay = new WeatherDataDisplay(weatherData);

        weatherData.setWeatherData(36.3f, 105.2f);
    }
}
