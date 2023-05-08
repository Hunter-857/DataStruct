package com.learn.java.ag;

public class leetcode198 {

    // 搞清楚DP的 方程式
    static public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if(len==1){return nums[0];}
        if(len==2){return Math.max(nums[0],nums[1]);}
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);// dp[1] = 7
        dp[2] = Math.max((nums[2]+ nums[0]),nums[1]);//dp[2] = 11
        for (int i = 3; i < len ; i++) {
            int tmp = dp[i-2] + nums[i];
            dp[i] = Math.max(tmp, dp[i-1]);

        }
        return dp[len-1];
    }


    public static void main(String[] args) {
        int[] mrob = new int[]{1,2,3,1};
        System.out.println(rob(mrob));

        int[] mrob1= new int[]{2,7,9,3,1};
        System.out.println(rob(mrob1));
    }
}
