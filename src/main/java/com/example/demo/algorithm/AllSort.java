package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AllSort {


    public static List<List<Integer>>  permute(int[] nums){
        //保存结果
        List<List<Integer>> res = new LinkedList<>();
        //      
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num:nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n,output,res,0);
        return res;
    }


    public static void backtrack(int n,
                        ArrayList<Integer> output,
                        List<List<Integer>> res,
                        int first) {
    // 所有数都填完了
      //   result = []
    // def backtrack(路径, 选择列表):
    //     if 满足结束条件:
    //         result.add(路径)
    //         return

    //     for 选择 in 选择列表:
    //         做选择
    //         backtrack(路径, 选择列表)
    //         撤销选择
    //全排列，N的阶乘
    if (first == n)
      res.add(new ArrayList<Integer>(output));
    for (int i = first; i < n; i++) {
      // 动态维护数组
      Collections.swap(output, first, i);
      // 继续递归填下一个数
      backtrack(n, output, res, first + 1);
      // 撤销操作
      Collections.swap(output, first, i);
    }
  }
  
  
  public static void main(String[] args) {
      int[] nums = {1,2,3};
      System.out.println(permute(nums));//3*2*1
  }
    
  
}