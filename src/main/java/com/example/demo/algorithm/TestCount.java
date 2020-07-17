package com.example.demo.algorithm;

public class TestCount {
    private volatile int count = 0;

    public synchronized void incr() {
        count++;
        
    }

    public static void main(String[] args) {
        new TestCount().incr();
}
} 