package com.learn.java.tree;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class leetcode47 {
    /**
     *  在 46 的基础上，加了一个去除重复的Stream
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>  ans = new ArrayList<>();
        Deque deque = new ArrayDeque();

        dfs(nums,0,deque,ans,new boolean[nums.length]);
        List result=  ans.stream().distinct().collect(Collectors.toList());
        return result;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> deque,
                     List<List<Integer>> ans,boolean[] used) {
        if(depth == nums.length){
            ans.add(new ArrayList<>(deque));
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                used[i] = true;
                continue;
            }
            deque.add(nums[i]);
            used[i] = true;
            dfs(nums,depth+1,deque,ans,used);
            deque.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        leetcode47 solution = new leetcode47();
        int[] nums = new int[]{1,1,2};
        solution.permuteUnique(nums);
    }
}
