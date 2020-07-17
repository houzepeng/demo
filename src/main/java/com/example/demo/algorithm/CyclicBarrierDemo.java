package com.example.demo.algorithm;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrierDemo
 */
public class CyclicBarrierDemo {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> {
        System.out.println("所有运动员到场,裁判员一声令下！！！");
    });

    public static void main(String args[]) {
        System.out.println("运动员准备进场全场欢呼！！！");
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            executorService.execute(() -> {
                try {
                System.out.println(Thread.currentThread().getName() + " 运动员，进场");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " 运动员，出发");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
             
            });
        }
    }


}