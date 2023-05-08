package str;

import java.util.*;

public class leetcode136 {
    /**
     *  leetcode 136
     *  利用异或，任何数组和自己异或结果是0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    /**
     *  leetcode 338
     *  2 --> 10
     *  3 --> 11
     *  11 & 10 = 1
     * @param n
     * @return
     */
    static public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i&(i-1)] +1;
        }
        return ans;
    }

    /**
     *  leetcode 461
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance2(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }

    /**
     *  leetcode 20
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //  长度是单数 ，则肯定不对
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Boolean result = false;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char readChar =  s.charAt(i);

            if( readChar == '(' || readChar =='[' || readChar =='{'){
                stack.push(readChar);
            }

            if(!stack.isEmpty()){
                if(readChar == ')' ){
                    char tmp =  stack.pop();
                    result = tmp == '(';
                }else if( readChar == ']' ) {
                    char tmp =  stack.pop();
                    result = tmp == '[';
                }else if(readChar =='}'){
                    char tmp =  stack.pop();
                    result = tmp == '{';
                }

            }

        }
        return result && stack.size()==0;
    }

    /**
     *   leetcode 20
     * @param s
     * @return
     */
    public  static  boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid1("({{{{}}}))"));
    }
}

/**
 *   ({{{{}}}))
 */
