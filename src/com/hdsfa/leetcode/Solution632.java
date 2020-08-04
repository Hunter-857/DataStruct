package com.hdsfa.leetcode;

import java.util.List;

public class Solution632 {

    /*
    *
    *  哈希表 + 滑动窗口
    *
    * */
    public int[] smallestRange(List<List<Integer>> nums) {
        int low= 0;
        int hight = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> innerlist ;
            if(i ==0){
                innerlist = nums.get(0);
                low = innerlist.get(innerlist.size()-1);
                hight = innerlist.get(innerlist.size());
            }else {
                innerlist =  nums.get(i);

            }
        }
        return new int[]{1,2};
    }

    public static void main(String[] args) {

    }
}
