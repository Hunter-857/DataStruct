package com.learn.java.arrays;

import java.util.*;

public class leetcode16 {


    static public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++; // 排序后的数组 还能向前移动一些
                else
                    return ans;
            }
        }
        return ans;
    }
    static public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList result = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i ,end = nums.length - 1 ,next = start +1;
            ArrayList findArr = new ArrayList();
            while (start < end){
                int sum = nums[start] + nums[next] +  nums[i] + nums[end];
                if( target == sum){
                    findArr.add(nums[start] );
                    findArr.add(nums[next] );
                    findArr.add(nums[i]);
                    findArr.add(nums[end]);
                    break;
                }
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++; // 排序后的数组 还能向前移动一些
            }
            result.add(findArr);
        }


        return result;
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> numberMap =  new HashMap();
        numberMap.put(2,"abc");
        numberMap.put(3,"def");
        numberMap.put(4,"ghi");
        numberMap.put(5,"jkl");
        numberMap.put(6,"mno");
        numberMap.put(7,"pqrs");
        numberMap.put(8,"tuv");
        numberMap.put(9,"wxyz");
        List<String> resultList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List keylist = new ArrayList();
        for (int i = 0; i < digits.length(); i++) {
            String key =  digits.substring(i,i+1);
            keylist.add(key);
        }

        for (int i = 0; i < keylist.size(); i++) {
            numberMap.get(keylist.get(i));

        }


        return resultList;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
        int[] nums2 = new int[]{1,0,-1,0,-2,2};
        System.out.println(fourSum(nums2,0));
    }
}
