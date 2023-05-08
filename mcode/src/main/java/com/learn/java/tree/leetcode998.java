package com.learn.java.tree;

import java.util.*;

public class leetcode998 {


    static public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            //找到底部
            if (root == null) {
                return new TreeNode(val);
            }
            //找到大于的节点
            if (root.val < val) {
                return new TreeNode(val, root, null);
            }
            //遍历右节点
            root.right = insertIntoMaxTree(root.right, val);
            return root;
    }
    //  不使用递归
    public TreeNode insertIntoMaxTree2(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                TreeNode node = new TreeNode(val, cur, null);
                parent.right = node;
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }
    public static int   maxDepth(TreeNode root) {
        int max = 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr =  root;
        while (curr !=null){
            System.out.print(curr.val + " ");
            stack.push(curr);
            curr = curr.left;
        }
        max = Math.max(stack.size(),max);
        while (!stack.isEmpty()){
            curr = stack.pop();
            System.out.print(curr.val + " ");
            while (curr.right!=null){
                stack.push(curr.right);
                curr = curr.right;
            }
        }
        //System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        insertIntoMaxTree(root,5);

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(1);
        insertIntoMaxTree(root1,3);


        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);

        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);

        maxDepth(root3);
    }
}
