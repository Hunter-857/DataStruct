package com.learn.java.ag;


public class leetcode740 {

    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        if(len ==1) return nums[0];
        if(len ==2){
            int tmpXEarch = nums[0];
            int tmpYEarch = nums[1];
            if (nums[0] - 1 == nums[1]  || nums[0] +1  == nums[1]) {
                tmpXEarch +=nums[1];
            }

            if (nums[1] - 1 == nums[0]  || nums[1] +1  == nums[0]) {
                tmpYEarch +=nums[0];
            }

            dp[1] = Math.max(tmpXEarch, tmpYEarch);
        }


        for (int i = 3; i < len; i++) {
            int tmpXEarch = dp[i-2]; //1
            int tmpYEarch = dp[i-1];// 2

            int tmp = dp[i-1];//1
            for (int j = 3; j < len ; j++) {
                if (nums[i] - 1 == nums[i]|| nums[i] +1 == nums[i]) {
                    tmp += nums[i];
                }
            }

            dp[1] = Math.max(tmpXEarch, tmpYEarch);
        }


        return dp[len-1];
    }

    public void  calculator(int[] dp ,int[] nums, int index){
        int len = nums.length;
        // 2


    }

    public static void main(String[] args) {

    }
}
