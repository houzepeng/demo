package com.example.demo.algorithm;

public class PizzaStore {
    SimplePizzaFactory factory;
    public PizzaStore(SimplePizzaFactory factory){
        this.factory = factory; 
    }

    public Pizza createPizza(String type){
        Pizza pizza;
        pizza = factory.createPizza(type);
        pizza.bake();
        pizza.box();
        pizza.cut();
        return pizza;
    }
}