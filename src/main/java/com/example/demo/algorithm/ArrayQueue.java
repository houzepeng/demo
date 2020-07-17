package com.example.demo.algorithm;

public class ArrayQueue {

    private String [] items;
    private int n=0;
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item){
        //tail=n，表示队列已经满了
        if(tail==n){
            return false;

        }
        items[tail] =item;
        ++tail;
        return true;
    }

    //出队列
    public String  dequeue(){
        /// 如果head == tail 表示队列为空
        if(head == tail){
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }

    public static void main(String[] args) {
        
    }
}