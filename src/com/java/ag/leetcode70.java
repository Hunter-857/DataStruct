package ag;

import java.util.ArrayList;

public class leetcode70 {

    /**
     *  N 比较大的时候,递归就超时了,所以有了方法2， p，q，r 相当于一个动态数组
     * @param n
     * @return
     */
    static public int climbStairs(int n) {
        if(n ==1){ return 1;}
        if(n ==2){return 2;}

        if(n > 3){
            System.out.println(n);
            n = climbStairs(n-1) + climbStairs(n-2);
        }

        return n;
    }

    /**
     *  滚动数组的思想
     * @param n
     * @return
     */
    static public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1; // f(1) = 1
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(19));
        System.out.println(climbStairs2(19));
    }

}
