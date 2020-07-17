package com.example.demo.algorithm;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "实现 Callable 接口通过 FutureTask 包装器来创建 Thread";
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CallableDemo3 callableDemo3 = new CallableDemo3();
        CompletionService completionService = new ExecutorCompletionService<>(executorService);
        completionService.submit(callableDemo3);
        Future<String> future;
        try {
            future = completionService.take();
    
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        executorService.shutdown();
    }
    
}