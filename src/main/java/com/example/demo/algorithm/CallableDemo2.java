package com.example.demo.algorithm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class CallableDemo2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "实现 Callable 接口通过 FutureTask 包装器来创建 Thread";
    }

    public static void main(String[] args) {
        CallableDemo2 callableDemo2 = new CallableDemo2();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(callableDemo2);

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        executorService.shutdown();
    }
    
}