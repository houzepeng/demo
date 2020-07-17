package com.example.demo.algorithm;

import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionDemo {
    
    public static void main(String[] args) {
       
        Stream<String> a = Stream.of("a","b","c","d");
        Stream<String> b = Stream.of("d","e");
        Stream<String> c = Stream.concat(a,b);
        System.out.println(c.count());
}
}