package com.hdsfa.leetcode;

import org.junit.Test;

public class Solution69 {
    /**
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        int low = 0, hight = x, ans = -1;
        while (low <= hight) {
            int mid = low + (hight - low) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            }
            else {
                hight = mid - 1;
            }
        }
        return ans;
    }

    /**
     *  二分查找 也可以有 精度
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        double low  = 0;
        double hight = x;
        double mid = (hight-low) /2;
        double dart = (mid * mid) -x;
        if (dart == 0) return (int) mid;
        while (Math.abs(dart) > 0.01){
            if(dart > 0){
                hight = mid;
                mid = (hight-low)/2;
            }else {
                low =mid;
                double tmp = (hight-low)/2;
                mid = mid + tmp;
            }
            System.out.println(mid);
            dart = mid * mid -x;
        }
        return (int) Math.round(mid);
    }




    @Test
    public void solution(){
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(8));
    }
}
