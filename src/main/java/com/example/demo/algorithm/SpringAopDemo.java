package com.example.demo.algorithm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * SpringAopDemo
 */
public class SpringAopDemo {

    
    public static void main(String[] args) {
        Object target;
        Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), SpringAopDemo.class, new InvocationHandler(){
        
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //1.执行前
                method.invoke(proxy, method, args);
                //2.执行后
                return null;
            }
        });
    }

}