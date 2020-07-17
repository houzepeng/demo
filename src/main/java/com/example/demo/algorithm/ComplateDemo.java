package com.example.demo.algorithm;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ComplateDemo {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out
                    .println("runAsync=" + Thread.currentThread().getName() + "|" + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("done=" + cf.isDone());
        TimeUnit.SECONDS.sleep(4);
        System.out.println("done=" + cf.isDone());

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(
                        "supplyAsync=" + Thread.currentThread().getName() + "|" + Thread.currentThread().isDaemon());
                return "message";

        }).thenApplyAsync(s -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("thenApplyAsync=" + Thread.currentThread().getName() + "|" + Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        // gotNow 如果成功就返回结果
        System.out.println(cf1.getNow(null));
        // 一直等待成功，然后返回结果
        System.out.println(cf1.join());
    }
}