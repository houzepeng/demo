package com.example.demo.algorithm;

public class DogAdapter implements Robot {
    Dog dog;

    public DogAdapter(Dog dog){
        this.dog = dog;
    }

    @Override
    public void cry() {
        System.out.println("机器人模拟狗叫...");
        dog.wang();

    }

    @Override
    public void move() {
        System.out.println("机器人模拟狗跑...");
        dog.run();
    }
    
}