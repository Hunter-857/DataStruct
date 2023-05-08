package com.learn.java.arrays;

import java.util.Arrays;

public class leetcode283 {

    /**
     *  数组这里 双指针比较多。
     *
     * @param nums
     */
    static public void moveZeroes(int[] nums) {
        if(nums.length <=1){return;}
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[index] !=0){
                index++;
            }
            if(nums[index] == 0  &&  nums[i] !=0){
                nums[index] = nums[i];
                nums[i] = 0; // 已经知道一个值为0 就可以不用交换value
            }
        }
    }

    /**
     *  leetcode 283
     *
     *  又是一个垃圾题
     */
    static public void moveZeroes2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == 0){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }



        Arrays.stream(nums).forEach(item -> System.out.print(item + ", "));
    }

    /**
     * leetcode 283
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        if(nums==null) {
            return;
        }
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0,3, 12};
        moveZeroes(nums);
    }
}
