package com.example.demo.algorithm;

import java.util.Arrays;

/**
 * RepeatNum
 */
public class RepeatNum {

    
    public static void main(String[] args) {
        
        int[] numss = {1,2,3,4};
        RepeatNum rNum = new RepeatNum();
        rNum.productExceptSelf(numss);
        
    }

    public  int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k; 
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
            System.out.println(res[i]+"--"+k);
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
            System.out.println(res[i]+"--"+k);
        }
        String s = Arrays.toString(res);
        System.out.println(s);
        return res;
    }
}