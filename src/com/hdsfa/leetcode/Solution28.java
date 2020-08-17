package com.hdsfa.leetcode;

public class Solution28 {

    /*
    *  28. https://leetcode-cn.com/problems/implement-strstr/
    *   1.暴力匹配
    *       执行用时 :1 ms, 在所有 Java 提交中击败了78.39% 的用户
    *       内存消耗 :43 MB, 在所有 Java 提交中击败了5.02%的用户
    *      行能太差啦 哈哈
    *
    * */
    public static int strStr(String haystack, String needle) {
        int pos = -1;
        int haystackLength = haystack.length();
        if(needle.length() ==0 ) return 0;
        for (int i = 0; i < haystackLength; i++) {
            if(needle.length()+ i > haystackLength)break;
            if(haystack.substring(i,i + needle.length()).equals(needle)){
                 pos = i;break;
            }
        }
        return  pos;
    }

    /*
     *  相似的查找算法有 KMP，BM，Horspool，
     *  KMP 字符匹配算法 1.需要查找的字符做 串前缀表 (最长公缀的方法 可以参考14题）
     *                    前缀不包含最后一个字母。
     *      *           2.最长公共前后缀
     *                  3.按照前缀表位移
     *
     * */
    public static int strStrKMP(String haystack, String needle) {
        // prefix table  "ABABCABAA"
        int strLength = haystack.length();
        int[] prefix = new int[strLength];
        int len= 0, i = 1;
        while (i < strLength){
            if(haystack.charAt(len) == haystack.charAt(i)){
                len++;
                prefix[i] = len;
                i++;
            }else{
                if(len > 0 ) {
                    len = prefix[len-1];
                } else{
                    prefix[i] = len;
                    i++;
                }
            }
        }
        int[] prefixTable = new int[strLength];
        prefixTable[0] = -1;
        //move to next
        for (int j = 1; j < prefix.length-1 ; j++) {
            prefixTable[j+1] = prefix[j];
        }
        //haystack = text[i]  len(text)      = n
        //needle   = pattern[j] len(pattern) = m
        int patternLen =  haystack.length();
        int SourceLen =  needle.length();
        int q =0 , j = 0;
        int index = -1;
        while(q < SourceLen){
            char patternChar = haystack.charAt(j);//P
            char SourceChar = needle.charAt(q);//T

            if(j == patternLen-1 && patternChar == SourceChar ){
                index = q-j;
                System.out.println("find"+ index);
                break;
            }
            if(patternChar == SourceChar){
                j++;q++;
            }else {
                j = prefixTable[j];
                if(j == -1){
                    q++;j++;
                }
            }

        }

        return index;
    }
    // 0 0 1 2 0 1 2 3 1
    public static int strStrKMP2(String haystack, String needle) {
        // prefix table  "ABABCABAA"
        int strLength = haystack.length();
        int[] prefix = new int[strLength+1];
        prefix[0] = -1;
        int len= 0, i = 1;
        while (i < strLength){
            if(haystack.charAt(len) == haystack.charAt(i)){
                len++;
                prefix[i] = len;
                i++;
            }else{
                if(len > 0 ) {
                    len = prefix[len-1];
                } else{
                    prefix[i] = len;
                    i++;
                }
            }
        }
        //move to next
        for (int j = 0; j < prefix.length; j++) {
            System.out.print(prefix[j]+" ");
        }
        return -1;
    }
    /*
    *
    *  挑了一个在实际情况中效果较好且理解简单的算法，即 Sunday 算法。
    * */
    public static int strStrSunny(String haystack, String needle) {

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("","a"));
        System.out.println(strStr("a","a"));
        System.out.println(strStr("aaaaa","bba"));
        System.out.println(strStr("aaaa","a"));
        // "ABABABABCABAAB"
        System.out.println(strStrKMP("ABABCABAA","ABABABABCABAAB"));
    }

}
