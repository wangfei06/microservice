package com.example.microservice.designpattern.observer;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    //观察者注册列表
    private List<Observer> observerList;

    private float temperature;

    private float pressure;

    public WeatherData() {
        observerList = new ArrayList<>();
    }


    /**
     * 注册观察者
     * @param observer 观察者
     */
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 取消订阅
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        int i = observerList.indexOf(observer);
        if (i >= 0) {
            observerList.remove(i);
        }

    }

    /**
     * 通知观察者变更
     */
    @Override
    public void notifyObservers() {
        if (!CollectionUtils.isEmpty(observerList)){
            //通知所有观察者（订阅者）
            for (Observer observer : observerList){
                observer.update(temperature, pressure);
            }
        }
    }


    public void weatherDataChanged(){
        notifyObservers();
    }

    public void setWeatherData(float temperature, float pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        //数据变更时调用通知观察者的方法
        weatherDataChanged();
    }
}
