package com.example.demo.algorithm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownDemo
 */
public class CountDownDemo {

    private static CountDownLatch startSignal = new CountDownLatch(1); // 裁判
    private static CountDownLatch endSignal = new CountDownLatch(4); // 运动员

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                try {
                System.out.println(Thread.currentThread().getName()+"运动员等待裁判哨响");
                    startSignal.await();
                System.out.println(Thread.currentThread().getName()+"正在全力冲刺");   
                    endSignal.countDown();
                System.out.println(Thread.currentThread().getName()+"到达终点");
                } catch (InterruptedException e) {
                   
                    e.printStackTrace();
                }
            });
        }
        System.out.println("裁判发号施令");
        startSignal.countDown();
        endSignal.await();
        System.out.println("所有运动员到达终点");
        executorService.shutdown();

    }


}