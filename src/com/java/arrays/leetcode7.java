package arrays;

public class leetcode7 {
    /**
     *    注意一下 超出Integer 最大的情况就可以。
     *
     *     类似的判断是不是回文数？ ===> 数字反转后是否相等。
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;
        boolean minus = false;
        if(x<0){
            minus = true;
            x = Math.abs(x);
        }
        while (x > 0){
            int last = x % 10;
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result =  result * 10 + last ;
            x = x/10;
        }

        return minus? -result : result;
    }


    static int climbStairsRec(int n) {
        if(n == 0) return  0;
        if(n == 1) return  1;
        if(n == 2) return 2;
        return climbStairsRec(n-1)+ climbStairsRec(n-2);
    }
    /**
     *  leetcode 70  hashmap  ,递归会超时
     *  借助hashmap 消除了递归
     * @param n
     * @return
     */
    static int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n>=0) dp[0] = 0;
        if(n>=1) dp[1] = 1;
        if(n>=2) dp[2] = 2;

        if(n > 3){}{
            for (int i = 3; i <=n ; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(10));
        System.out.println(climbStairsRec(10));
    }

}
