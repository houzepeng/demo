package com.example.demo.algorithm;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.Future;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        // ExecutorService executorService = new ThreadPoolExecutor(10, 20, 1000,
        // TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), new
        // ThreadPoolExecutor.CallerRunsPolicy());

        // executorService.submit(future);

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(3000);
                completableFuture.complete("异步执行结束");
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
        });


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
 
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
 
        System.out.println("CompletableFuture");

    }
    
}