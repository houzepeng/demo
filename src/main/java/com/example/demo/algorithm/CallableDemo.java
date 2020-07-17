package com.example.demo.algorithm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        String testcall = "测试callbale返回数据";
        Thread.sleep(3000);
        return testcall;
    }

    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask task = new FutureTask<>(callableDemo);
        Thread t1 = new Thread(task);
        t1.start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}