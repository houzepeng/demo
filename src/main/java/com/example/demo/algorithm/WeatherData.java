package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers;
    private float temp;
    private float pressure;
    private float humidity;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i>=0){
        observers.remove(i);
        }
    }

    @Override
    public void noticeObserver() {
       for (int i = 0; i < observers.size(); i++) {
           Observer observer = observers.get(i);
           observer.update(temp, humidity, pressure);
       }

    }

    public void measurementChanged(){
        noticeObserver();
    }
    

    public void setMeasurements(float temp,float humidity,float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}