package com.example.demo.algorithm;

public abstract class File {
    
     String name;

     public File(String name){
         this.name = name;
     }

     public void setFile(String name){
         this.name = name;
     }
     public String getName(){
         return name;
     }

     public abstract void display();
}