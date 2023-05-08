package com.learn.java.tree;

import java.util.Stack;

public class leetcode946 {

    // 注意搞 对 i，j 模拟过程就可以了
   static public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack  = new Stack<>();
        for (int i = 0, j = 0 ; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() &&stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

   static public int leftSearch(int[] nums,int target) {
       int start = 0 ;
       int end = nums.length - 1;
       boolean findValue = false;
       int mid  = -1;
       while (end > start){
            mid  =  (end + start) /2;
           if(nums[mid] == target){
               findValue = true;
               break;
           } else if (nums[mid] < target) {
               start = mid + 1;
           }else {
               end = mid -1;
           }
       }

       if (findValue && nums[mid-1] == target){
           while (nums[mid] ==target){
               mid--;
           }
       }
       System.out.println(mid);
       return mid;
    }


   public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{4,5,3,2,1};

        System.out.println(validateStackSequences(nums1,nums2));

       int[] nums3 = new int[]{1,2,2,2,3,4,5,6,7,8};
       leftSearch(nums3,2);

   }
}
