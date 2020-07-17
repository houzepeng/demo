package com.example.demo.algorithm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHadder implements InvocationHandler {

    private Object object;
    public MyInvocationHadder( Object object){
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invokeHader sayHello");
        Object result = method.invoke(object, args);
        return result;
    }

    public static void main(String[] args) {
        Hello hello = new HelloInpl();
        MyInvocationHadder myInvocationHadder = new MyInvocationHadder(hello);
        Hello proxyHello = (Hello)Proxy.newProxyInstance(HelloInpl.class.getClassLoader(),  HelloInpl.class.getInterfaces(), myInvocationHadder);
        proxyHello.sayHello();
    }
    
}