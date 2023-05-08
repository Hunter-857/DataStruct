package com.learn.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode345 {

    /**
     *  自己高的 比较慢
     * @param s
     * @return
     */
   static public String reverseVowels(String s) {
       List<String> list =  Arrays.asList(new String[]{"a","e","i","o","u"});
       ArrayList<Integer> index = new ArrayList();
       char[] charArray = s.toCharArray();
       for (int i = 0; i < charArray.length; i++) {
           String a = s.substring(i,i+1);
           if(list.contains(a.toLowerCase())){
               index.add(i);
           }
       }

       int size = index.size();
       for (int k = 0; k < size-1; k++) {
           int wei  = (int) index.get(k);
           int next = (int) index.get(size-1-k);
           //必须是后面 和前面的 字母交换
           if(wei < next){
               char tmp = charArray[wei];
               charArray[wei] = charArray[next];
               charArray[next] = tmp;
           }

       }

       return new String(charArray);
    }
    static public String reverseVowels2(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    static public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    static  public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        String reverse = reverseVowels("race car");
        System.out.println(reverse);


        String reverse3 = reverseVowels2("race car");
        System.out.println(reverse3);


        String reverse2 = reverseVowels("leetcode");
        System.out.println(reverse2);

        //leetcode --> leetcode --> leotcede
        String reverse4 = reverseVowels2("leetcode");
        System.out.println(reverse4);

    }
}
