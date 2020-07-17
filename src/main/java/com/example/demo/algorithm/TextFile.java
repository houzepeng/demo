package com.example.demo.algorithm;

public class TextFile extends File {

    public TextFile(String name){
        super(name);
    }

    @Override
    public void display() {
    
        System.out.println("这是文本文件，名称是"+super.getName());

    }
    
}