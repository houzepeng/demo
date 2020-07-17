package com.example.demo.algorithm;

public class ThreadDemo extends Thread{
    
    @Override
    public void run(){
        System.out.println("继承 Thread 类创建线程");
    }
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        t1.start();
    }
}