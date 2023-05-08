package com.learn.java.str;

public class leetcode50 {
    /**
     *  一个 一个相乘可以完成，但不是一个很好的办法。
     *
     *  利用一些数学方法：
     *     x → x^2 → x^4 →x^8 →x^16 →x^32
     *   幂的次数如果是：
     *          偶数，就直接 平方来搞
     *          奇数，则在平方最后多乘一个 x
     * @param x
     * @param n
     * @return
     */
    static public double myPow(double x, int n) {
        double result = 1;
        if (n==0)return 1;
        if(x ==1) return 1;
        for (int i = 0; i < Math.abs(n); i++) {
            result =  result * x ;
        }
        if(n < 0){
            result = 1/result;
        }
        return result;
    }

    /**
     *  leetcode50
     *
     *
     * @param x
     * @param n
     * @return
     */
    static public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }

     static  public double quickMul2(double x, long N) {
            if (N == 0) {
                return 1.0;
            }
            double y = quickMul2(x, N / 2);
            return N % 2 == 0 ? y * y : y * y * x;
        }

    /**
     *  恰好就对应了 7777 的二进制表示 (1001101)
     *
     * @param x
     * @param n
     * @return
     */
    static public double myPow3(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul3(x, N) : 1.0 / quickMul3(x, -N);
    }

    static public double quickMul3(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N = N >> 1;
        }
        return ans;
    }




    public static void main(String[] args) {
        System.out.println(myPow3(2,10));
        System.out.println(myPow3(2.1,3));
        System.out.println(myPow3(2,-2));





    }
}
