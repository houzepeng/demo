package com.example.demo;

import com.example.demo.algorithm.ClassForName;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class TestClassForname {

    @Test
    public void test() {
        try {
            //class.forName会加载静态代码块，而classLoader不会 
            Class.forName("com.example.demo.algorithm.ClassForName");
           // ClassLoader.getSystemClassLoader().loadClass("com.example.demo.algorithm.ClassForName");
            System.out.println("#####结束符=====");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}