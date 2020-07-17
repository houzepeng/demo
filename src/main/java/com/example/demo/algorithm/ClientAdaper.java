package com.example.demo.algorithm;

public class ClientAdaper {

    public static void main(String[] args) {
        
       Dog dog = new Dog();
       DogerAdapter dogerAdapter = new DogerAdapter(dog);
       dogerAdapter.cry();
       dogerAdapter.move();;
    }

}