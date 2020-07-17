package com.example.demo.algorithm;

public class FindValueInArray {

 

    public static void main(String[] args) {
        int[] arrData = {1,2,3,4,5};
        int key = 4;
        int n = 5;
        System.out.println(findValue(arrData,n,key));
    }

    public static int findValue (int[] arr,int n,int k){
      if(arr == null || n<=0){
          return -1;
      }
      int i = 0;
      while(i<n){
        if(arr[i] == k){
            return i;
        }
        ++i;
      }
        return 1;
    }
    
}