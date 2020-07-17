package com.example.demo.algorithm;

/**
 * SumDemo2
 */
public class SumDemo2 extends Thread {

    int sum = 0;

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            sum = sum+i;
          
        }
        System.out.println("---"+sum);
    }


    public static void main(String[] args) {
        SumDemo2 sd = new SumDemo2();
        sd.start();
    }
    
}