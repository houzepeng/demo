package com.example.demo.algorithm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest  extends Thread{
    
     public  int count = 10;

     public ReentrantLock lock;
     

     @Override
     public  void run(){
         boolean flag = true;
         while(flag){
           
            try {
                lock.lock();
                if(count>0){
               
                    count--;
                   
                    System.out.println(count);
                }
                else{
                    System.out.println("没数了");
                    flag = false;
                } 
            } catch (Exception e) {
                System.out.println("err");
            }
            finally{
                lock.unlock();
            }
             
         }
        
        
        
     }


     public static void main(String[] args) {
         ThreadTest threadTest = new ThreadTest();

         Thread  t1 = new Thread(threadTest);
         Thread  t2 = new Thread(threadTest);
         Thread  t3 = new Thread(threadTest);
         t1.start();
         t2.start();
         t3.start();
     }

}