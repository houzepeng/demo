package com.example.demo.algorithm;

public class WeatherStation {
 
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentCondituonDisplay condituonDisplay = new CurrentCondituonDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 78, 40.4f);
    }
}