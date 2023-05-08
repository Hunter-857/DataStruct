package com.learn.java.arrays;

import java.util.*;
import java.util.function.Consumer;

public class leetcode39 {

    // 回溯算法
    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans =  new ArrayList<>();
        Deque<Integer> inner = new ArrayDeque<>();
        //boolean[] used = new boolean[candidates.length];
        backTrack(ans,target,candidates,inner);
        //backTrack2(ans,target,candidates,inner,0);
        return ans;
    }

    static public void backTrack(List<List<Integer>> ans ,int target, int[] candidates, Deque<Integer> inner) {

        if(target==0){
            ans.add(new ArrayList<>(inner));
            return;
        }else {
            for (int i = 0; i < candidates.length; i++) {
                if(target > 0){
                    target = target - candidates[i];
                    inner.add(candidates[i]);
                    backTrack(ans,target,candidates,inner);
                }else {
                    inner.removeLast();
                    target = target + candidates[i];
                   // removedOne = true;=
                }
            }
        }
    }

    /**
     *  leetcode 2418 啥也不是啊，哈哈
     */
    public static String[] sortPeople(String[] names, int[] heights) {

        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                if(heights[i] < heights[j]){
                    int tmp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = tmp;

                    String tmpName = names[i];
                    names[i] =names[j];
                    names[j] = tmpName;

                }
            }
        }
        Arrays.stream(names).forEach(s -> System.out.print(s  + " "));
        return names;
    }

    public static void main(String[] args) {
        // candidates = [2,3,6,7], target = 7
        int[] arrays = new int[]{2,3,6,7};
        //  candidates = [2,3,5], target = 8
        //System.out.println(combinationSum(arrays, 7));
        // candidates = [2,3,5], target = 8

        String[] names = new String[]{"Mary","John","Emma"};
        int[] heights = new int[]{180,165,170};
        sortPeople(names,heights);
        System.out.println("");
        String[] names1 = new String[]{"Alice","Bob","Bob"};
        int[] heights1 = new int[]{155,185,150};
        sortPeople(names1,heights1);
    }
}
