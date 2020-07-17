package com.example.demo.algorithm;

public class BridgeClient {
    
    public static void main(String[] args) {
        Color color = new White();
        Shape shape = new Circle();
        shape.setColor(color);
        shape.draw();
        //当两个类都存在变化的时候可以通过桥接模式实现
        //比如图形可以有多个形状，颜色可以有多个颜色
    }
}