package com.example.demo.algorithm;

public  abstract class Shape {
    Color color;

    public void setColor(Color color){
        this.color = color;
    }


    public abstract void draw();
}