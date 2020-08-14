package com.hdsfa.leetcode;

import org.junit.Test;

public class Solution {

    /*
    *  暴力可以解决一切
    * */
    public int findMagicIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == i){
                return i;
            }
        }
       return -1;
    }
    /**/
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
    /**
     *
     * @param nums
     * @return
     */
    public static int findMagicIndex2(int[] nums){

        if(nums[0]==0){
            return 0;
        }
        int right = 0;
        int left = nums.length;
        int mid = (right + left) /2 ;
        while (mid > 0){
            System.out.println(mid);
           if(nums[mid] == mid){
               return mid;
           }else if(nums[mid] > mid){
               left = mid;
           }else {
               right = mid;
           }
            mid = (right + left) /2 ;
       }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int preSum = nums[0];
        int result = -1;
        for (int j = 1; j < nums.length-1; j++) {
           preSum += nums[j];
           int endSum = nums[j+1];
           for (int i = j+1; i <nums.length-j ; i++) {
               endSum += nums[i+1];
               if(preSum == endSum){
                    result = i;
               }else if(preSum > endSum){
                   break;
               }
           }
        }
        return result;
    }

    @Test
    public  void solutions() {
        int[] nums = {0, 2, 3, 4, 5};
        System.out.println(findMagicIndex2(nums));
        int[] number1= {1, 2, 3};
        int[] number2= {1, 7, 3, 6, 5, 6}; //3
                      //[1,7,3,6,5,6]
        int[] number3= {-1,-1,-1,-1,-1,-1};
        int[] number4= {-1,-1,-1,0,1,1};//0
        int[] number5= {-1,-1,0,1,1,0};//5

    }
}
