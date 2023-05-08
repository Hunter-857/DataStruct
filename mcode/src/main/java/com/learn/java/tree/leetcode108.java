package com.learn.java.tree;

import java.util.Random;
import java.util.Stack;

public class leetcode108 {


    static public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode  pre =  new TreeNode(nums[0]);
        Stack stack = new Stack();
        stack.push(pre);
        TreeNode root = null ;
        for (int i = 1; i < nums.length; i++) {
            TreeNode next = new TreeNode(nums[i]);
            if(next.val > pre.val){
                stack.push(next);
                pre = next;
            }

            while (!stack.isEmpty()){
                TreeNode top = (TreeNode) stack.pop();
                if(root == null){
                    root = top;
                }else {
                    root.left = top;
                }
            }

        }


        return pre;
    }
    Random rand = new Random();
    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        sortedArrayToBST(nums);
    }

}
