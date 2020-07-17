package com.example.demo.algorithm;

public class SimplePizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }
        /* else if(type.equals("clam")){
            pizza = new ClamPizza();
        }
        else if(type.equals("pepperoni")){
            pizza = new PepperoniPizza();
        }
        else if(type.equals("veggie")){
            pizza = new VeggiePizze();
        } */
        //多行注释alt+shift+A

 return pizza;
    }
    
}