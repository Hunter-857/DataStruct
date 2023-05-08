package com.learn.java.arrays;

public class leetCode66 {

    /**
     *  纯逻辑哈哈   在所有Java 提交中击败了 100.00%的用户
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int lastNumIndex = digits.length - 1;
        boolean plus = false;
        for (int i = lastNumIndex; i >= 0; i--) {
            int tmp = digits[i] +1;
            if(i == lastNumIndex){
                if(tmp == 10){
                    digits[i] = 0;
                    plus = true;
                }else {
                    digits[i] = tmp;
                }
            }else if(plus){
                if(tmp == 10){
                    digits[i] =0;
                }else {
                    digits[i] +=1;
                    plus = false;
                }
            }

        }
        if(plus){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    /**
     *  leetcode11  暴力循环会超时
     * @param height
     * @return
     * */
    public static int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int j = i+1;
            while (j < length ){
                if(height[i] < height[j]){
                    max = Math.max(max, height[i] * (j-i));
                }else {
                    max = Math.max(max, height[j] * (j-i));

                }
                j++;
            }

        }
        return max;
    }

    /**
     * leetcode11  双指针法
     * @param height
     */

    public static int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        //int[] digits = new int[] {1,9,9};
        //int[] digits = new int[] {1,2,3};
        //int[] digits = new int[] {4,3,2,1};
       // int[] digits = new int[]{8,9,9,9};
        //int[] digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] digits = new int[]{1,8,6,2,5,4,8,3,7};
        int[] digits1 = new int[]{1,2,1};
        System.out.println(maxArea(digits));
        System.out.println(maxArea(digits1));
    }
}
