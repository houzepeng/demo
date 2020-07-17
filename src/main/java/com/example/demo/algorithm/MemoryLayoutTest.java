package com.example.demo.algorithm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class MemoryLayoutTest {
    public static void main(String[] args){

        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(ArrayQueue.class).toPrintable());
        System.out.println("------------------");
        boolean[] value = new boolean[3];
        System.out.println(ClassLayout.parseInstance(value).toPrintable());
    }
}