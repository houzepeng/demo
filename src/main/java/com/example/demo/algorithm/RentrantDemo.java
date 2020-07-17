package com.example.demo.algorithm;

import java.util.concurrent.locks.ReentrantLock;

public class RentrantDemo  implements Runnable{

    public static ReentrantLock reentrantLock =  new ReentrantLock();
      int i = 0;
      int sum = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
         // reentrantLock.lock();
           sum = sum+i;
         //  reentrantLock.unlock();
        }
        System.out.println(sum);

    }

    public static void main(String[] args) throws InterruptedException {
        RentrantDemo rDemo = new RentrantDemo();
        Thread t1 = new Thread(rDemo);
        Thread t2 = new Thread(rDemo);
        t1.start();
        t2.start();
       // t1.join();
     //   t2.join();
       // System.out.println(i);
    }
    
}   