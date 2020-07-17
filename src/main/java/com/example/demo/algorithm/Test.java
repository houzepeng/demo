package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {public static void getRepeateNum( int[] num) {	
    int NumChange;
    System.out.println("重复数字是：");
    for(int index = 0; index < num.length; index++) {
        while(num[index] != index) {
            if(num[index] == num[num[index]]) {
                System.out.print(num[index]+" ");
                break;
            } else {
                NumChange = num[num[index]];
                num[num[index]] = num[index];
                num[index] = NumChange;
            }	
        }
    }	
}

public static void main(String[] args) {
    
    int[] num = {22,33,22,22};
    
    getRepeateNum(num);
}

}