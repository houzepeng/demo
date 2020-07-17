package com.example.demo.algorithm;

public class Instructor extends Leader {
    public Instructor(String name){
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode LeaveNode) {
       if(LeaveNode.getNumber()<=3){
        System.out.println("辅导员" + name + "审批" +LeaveNode.getPerson() + "同学的请假条,请假天数为" + LeaveNode.getNumber() + "天。");
       }
       else if(this.successor!= null){
        this.successor.handleRequest(LeaveNode);
       }
    }
    
}