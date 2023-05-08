package com.learn.java.str;

import java.util.HashMap;
import java.util.Map;

public class leetcode290 {
    /**
     * 方法一：哈希表
     * 思路及解法
     *
     * 在本题中，我们需要判断字符与字符串之间是否恰好一一对应。即任意一个字符都对应着唯一的字符串，
     * 任意一个字符串也只被唯一的一个字符对应。在集合论中，这种关系被称为「双射」。
     *
     * 想要解决本题，我们可以利用哈希表记录每一个字符对应的字符串，以及每一个字符串对应的字符。
     * 然后我们枚举每一对字符与字符串的配对过程，不断更新哈希表，如果发生了冲突，则说明给定的输入不满足双射关系。
     *
     * 在实际代码中，我们枚举 pattern 中的每一个字符，利用双指针来均摊线性地找到该字符在
     * str 中对应的字符串。每次确定一个字符与字符串的组合，
     * 我们就检查是否出现冲突，最后我们再检查两字符串是否比较完毕即可。
     *   so, 遍历切保证map是对的返回 true
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();

        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }
    /**
     *      abba   "dog cat cat dog"
     *      a --> dog
     *      b --> cat
     *      b --> cat
     *      a --> dag
     */

    public static boolean wordPattern2(String pattern, String str) {
       // Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        String[] strArray = str.split(" ");

        for (int j = 0; j < strArray.length; j++) {
            String splitStr = strArray[j];
            char patternChar = pattern.charAt(j);
            if(ch2str.isEmpty() ||!ch2str.keySet().contains(patternChar)){
                ch2str.put(patternChar,splitStr);
            }else {
                if(!splitStr.equals(ch2str.get(patternChar))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
