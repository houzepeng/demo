package com.example.demo.algorithm;

/**
 * SumDemo
 */
public class SumDemo implements Runnable {

    int sum = 0;
    int p = 1;

    @Override
    public void run() {

       for (int i = 0; i < 100; i++) {
           sum = sum+i;
           p++;
       }
       System.out.println("------"+sum);
       System.out.println("------"+p);
    }


    public static void main(String[] args) {
        SumDemo sd = new SumDemo();
        Thread td = new Thread(sd);
        td.start();
    }
    
}