package com.example.demo.algorithm;

public class ClientBuilderTest {
    
    public static void main(String[] args) {
        KFCWaiter kfcWaiter = new KFCWaiter();
        //套餐A
        MealA a = new MealA();
         //服务员准备套餐A
         kfcWaiter.setMealBuilder(a);
          //获得套餐
        Meal mealA = kfcWaiter.construct();
        System.out.print("套餐A的组成部分:");
        System.out.println(mealA.getFood()+"---"+mealA.getDrink());
    }
}