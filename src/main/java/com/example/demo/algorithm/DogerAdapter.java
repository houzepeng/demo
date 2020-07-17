package com.example.demo.algorithm;

public class DogerAdapter  implements Robot{

    Dog  dog;

    public DogerAdapter(Dog dog){
        this.dog = dog;
    }

    @Override
    public void cry() {
        System.out.println("机器人学狗叫");
        dog.wang();

    }

    @Override
    public void move() {
        
        System.out.println("机器人学狗移动");
        dog.run();
    }
    
}