package com.learn.java.arrays;

import java.util.*;

public class leetcode88 {
    /**
     *  垃圾 忽略了吧
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
   static public void merge(int[] nums1, int m, int[] nums2, int n) {

       for (int i = 0;i < n;i++){
           nums1[m+i] = nums2[i];
       }
       Arrays.sort(nums1);
       Arrays.stream(nums1).forEach(item -> System.out.print(item + ", "));
    }

}
