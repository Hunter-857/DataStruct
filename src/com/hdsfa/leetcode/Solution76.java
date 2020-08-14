package com.hdsfa.leetcode;

import java.util.*;

public class Solution76 {
    /**
     *   相似的题型  leetcode 3，209，424，438，567
     */
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    /**
     *  哈希表 + 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int left = 0, rigtht = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();

        while (rigtht < sLen) {
            ++rigtht;
            char rightChar = s.charAt(rigtht);
            if (rigtht < sLen && ori.containsKey(rightChar)) {
                cnt.put(s.charAt(rigtht), cnt.getOrDefault(rightChar, 0) + 1);
            }
            while (check() && left <= rigtht) {
                if (rigtht - left + 1 < len) {
                    len = rigtht - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                char leftChar = s.charAt(left);
                if (ori.containsKey(leftChar)) {
                    cnt.put(leftChar, cnt.getOrDefault(leftChar, 0) - 1);
                }
                ++left;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }


    /**
     *    做加法的思路
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
         int sLen = s.length();
         int tLen = t.length();
         if(sLen ==0 || tLen ==0 || sLen < tLen){
             return "";
         }
        char[]  charArrayS = s.toCharArray();
        char[]  charArrayT = t.toCharArray();

         // ascii 'z' = 122
         int[] winFreq = new int[128];
         //记录频数
         int[] tFreq = new int[128];
        for (char c:charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部 包含多少 T 中的字符，对应字符频数超过不重复计算
        int distanc = 0;
        int minlen = sLen +1 ;
        int begin = 0;

        int left = 0;
        int right = 0;
        //[left , right)
        while (right < sLen){
            char rightChar = charArrayS[right];
            if(tFreq[rightChar] ==0){
                right++;
                continue;
            }
            if(winFreq[rightChar] < tFreq[rightChar]){
                distanc++;
            }
            winFreq[rightChar]++;
            right++;
            while (distanc == tLen){
                if( right - left < minlen){
                    minlen = right-left;
                    begin =left;
                }
                char leftChar = charArrayS[left];
                if(tFreq[leftChar] ==0){
                    left++;
                    continue;
                }
                if(winFreq[leftChar] == tFreq[leftChar]){
                    distanc--;
                }
                winFreq[leftChar]--;
                left++;
            }
        }
        if(minlen == sLen+1){
            return "";
        }
        return s.substring(begin,begin+minlen);
    }

    /**
     *    做减法的思路
     * @param s
     * @param t
     * @return
     */
    public static String minWindow2(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen ==0 || tLen ==0 || sLen < tLen){
            return "";
        }
        char[]  charArrayS = s.toCharArray();
        char[]  charArrayT = t.toCharArray();

        //记录频数
        int[] tFreq = new int[128];
        for (char c:charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部 包含多少 T 中的字符，对应字符频数超过不重复计算
        int distanc = tLen;
        int minlen = sLen +1 ;
        int begin = 0;

        int left = 0;
        int right = 0;
        //[left , right)
        while (right < sLen){
            char rightChar = charArrayS[right];
            if(tFreq[rightChar] >0){
                distanc--;
            }

            tFreq[rightChar]--;
            right++;
            while (distanc == 0){
                if( right - left < minlen){
                    minlen = right-left;
                    begin =left;
                }
                char leftChar = charArrayS[left];

                if(tFreq[leftChar]==0){
                    distanc--;
                }
                tFreq[leftChar]++;
                left++;
            }
        }
        if(minlen == sLen+1){
            return "";
        }
        return s.substring(begin,begin+minlen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));

        Solution76 sl = new Solution76();
        System.out.println(sl.minWindow1("ADOBECODEBANC","ABC"));

    }
}
