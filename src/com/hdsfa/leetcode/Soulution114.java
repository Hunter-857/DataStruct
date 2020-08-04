package com.hdsfa.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Soulution114 {

     //Definition for a binary tree node.
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public  static void flatten(TreeNode root) {
        while (root !=null){
          TreeNode next =  root.left;
          if(next.left == null && root.right !=null){
               root.right = next.left ;
          } else {
              root = root.left;
          }
        }
     }

    public static void main(String[] args) {
         TreeNode node3 = new TreeNode(3);
         TreeNode node4 = new TreeNode(4);
         TreeNode node6 = new TreeNode(6);
         TreeNode node5 = new TreeNode(5,null,node6);
         TreeNode node2 = new TreeNode(2,node3,node4);
         TreeNode node1 = new TreeNode(1,node2,node5);

         flatten(node1);
     }

}
