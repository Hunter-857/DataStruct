package com.learn.java.tree;

import java.util.*;

public class leetcode409 {

    // 贪心算法 哈希
    // 1.奇数类型的回文字符串，除了中间，其他字符对称
    // 2.偶数个字符的回文串： 所有字符都是镜面对称 出现此时都是偶数
    // 字母出现的搜是偶数次， 或者一个数字 加所有偶数次的字母
    // 用hash 表来 存储字母出现的次数
    //
    static public int longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) return 1;
        int[] count = new int[128];
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }
        // 出现次数的数组哈希
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     *  leetcode 441
     *  @param n
     *  @return
     */
    public static int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     *  直接循环纵向，比较就可以了
     * @param strs
     * @return
     */
    static public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /**
     * 方法一：横向扫描
     * @param strs
     */
    static public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix2(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    static public String longestCommonPrefix2(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {
        int longest = longestPalindrome("abccccdd");
        System.out.println(longest);
        int num1 = arrangeCoins(3);
        //int num2 = arrangeCoins(1804289383);
        System.out.println(num1);
        //System.out.println(num2);
        String x = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(x);

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(1);

    }
}

