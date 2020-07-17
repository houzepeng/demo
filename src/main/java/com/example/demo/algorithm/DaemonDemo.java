package com.example.demo.algorithm;

public class DaemonDemo {
   
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThread(), "DaemonThread");
        thread.setDaemon(true);
        thread.start();
    }

        static class DaemonThread implements Runnable {
            @Override
            public void run() {
                try {
                   Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    System.out.println("DaemonThread finally run.");
                }
            }
        }
}