package com.example.demo.algorithm;

/**
 * VolatileDemo
 */
public class VolatileDemo {

    private static volatile VolatileDemo volatileDemo = null;

    public static VolatileDemo getIntance(){
        if(volatileDemo ==null){
            volatileDemo = new VolatileDemo();
        }
        return volatileDemo;
    }

    public static void main(String[] args) {
        VolatileDemo.getIntance();
    }
    
}