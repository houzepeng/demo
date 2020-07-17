package com.example.demo.algorithm;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] a,int n){
        if (n <= 1) return;
//int a[] = {4,2,1,6,2,7,8,5};
        for(int i=1;i<n;i++){
            for (int j = i-1; j>=0&&a[j]>a[j+1]; j--) {
                int tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
            }
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int a[] = {4,2,1,6,2,7,8,5};
        insertSort(a,8);
    }
    
}