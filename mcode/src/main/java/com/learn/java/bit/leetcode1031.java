package com.learn.java.bit;

public class leetcode1031 {

    /**
     *  思路 构造了一个 sum[i] 的数组
     *  中间一段数组的长度，就是行 sum[j] - sum[i]
     * @param nums
     * @param firstLen
     * @param secondLen
     * @return
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }

        return Math.max(
                helper(firstLen, secondLen,s), helper(secondLen, firstLen, s)
        );
    }

    private int helper(int firstLen, int secondLen,int[] sum) {
        int ans = 0;
        for (int i = firstLen, t = 0; i + secondLen - 1 < sum.length-1; ++i) {
            t = Math.max(t, sum[i] - sum[i - firstLen]);
            ans = Math.max(ans, t + sum[i + secondLen] - sum[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        //nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
        leetcode1031 solution  = new leetcode1031();
        int[] nums = new int[]{0,6,5,2,2,5,1,9,4};
        int test = solution.maxSumTwoNoOverlap(nums,1,2);
        System.out.println(test);

    }
}
