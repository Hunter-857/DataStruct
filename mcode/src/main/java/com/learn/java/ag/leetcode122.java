package com.learn.java.ag;

public class leetcode122 {


    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==1){
            return prices[0];
        }
        if(len ==2){
            //int tmpX = Math.max(prices[0],prices[1]);
            return prices[1] - prices[0];
        }else {

            // 1,2,3   p[3]- p[2], p[2]-p[1], p[3]-p[1]
            //                     dp[1]
            


            return 1;
        }

    }


    public static void main(String[] args) {
        int[] test1 = new int[]{7,1,5,3,6,4};
        int[] test2 = new int[]{1,2,3,4,5};
        int[] test3 = new int[]{7,6,4,3,1};
        leetcode122 solution = new leetcode122();
        System.out.println(solution.maxProfit(test1));
       // System.out.println(solution.maxProfit(test2));
       //  System.out.println(solution.maxProfit(test3));
    }
}
