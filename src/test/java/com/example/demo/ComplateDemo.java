package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class ComplateDemo {

    @Test
public void test() throws InterruptedException {
    CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
        System.out.println("runAsync=" + Thread.currentThread().getName() + "|" + Thread.currentThread().isDaemon());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    System.out.println("done=" + cf.isDone());
    TimeUnit.SECONDS.sleep(4);
    System.out.println("done=" + cf.isDone());
}
    
}