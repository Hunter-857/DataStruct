package com.hdsfa.leetcode;

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



    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 5};
        System.out.println(findMagicIndex2(nums));
    }
}
