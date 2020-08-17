package com.hdsfa.leetcode;

import org.junit.Test;

public class Solution35 {

    /**
     * leetcode 35;
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if(nums[0] > target){return  0;}
        if(nums[nums.length-1] < target){return  nums.length;}
        for (int i = 0; i < nums.length -1 ; i++) {
            if(nums[i]< target && nums[i+1] >= target){
                return  i+1;
            }
        }
        return 0;
    }

    @Test
    public  void solutions() {
        int[] number1= {1, 3,5 ,6};
        System.out.println(searchInsert(number1,5));
        System.out.println(searchInsert(number1,2));
        System.out.println(searchInsert(number1,7));
        System.out.println(searchInsert(number1,0));
    }

}
