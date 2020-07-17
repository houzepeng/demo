package com.example.demo.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * RemoveDuplicates
 */
public class RemoveDuplicates {

   

    public static void main(String[] args) {
        int[] list = {1,1,2,2,3,4,5};
        RemoveDuplicates dd = new RemoveDuplicates() ;
        dd.removeDuplicates(list);
    }

   public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
    if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
    }
    }
    System.out.println(Arrays.toString(nums));
        return i + 1;

}
}


