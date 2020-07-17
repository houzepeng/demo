package com.example.demo.algorithm;

public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("实现runnable");
    }


    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread t1 = new Thread(runnableDemo);
        t1.start();
    }
    
}