package com.learn.java.tree;

import java.util.Stack;

public class leetcode112 {
    /**
     *   题解递归调用
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);

    }

    /**
     *  自己的 解法本来想用 stack 消除递归 但是总不对。
     * @param root
     * @param targetSum
     * @return
     */

    static  public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack();
        boolean result = false;
        int sum = 0 ;
        while (root !=null || !stack.isEmpty()){
            while (root !=null){
                stack.push(root);
                //sum += root.val;
                root = root.left;
            }

            root  = stack.pop();
            if(root !=null){
                sum += root.val;

            }
            root  = root.right;
            if(root !=null){
                sum -= root.val;
            }

            if(sum == targetSum) {
                result = true;
                break;
            }

        }
        return  result;
    }
    /**
     *  广度优先
     * @param root
     * @param targetSum
     * @return
     */

    static  public boolean hasPathSum3(TreeNode root, int targetSum) {

        return  false;
    }
    public static void main(String[] args) {
      // TreeNode node = new TreeNode(5);
      // node.left = new TreeNode(4);
      // node.right = new TreeNode(8);
      // node.right.left = new TreeNode(13);
      // node.right.right = new TreeNode(4);
      // node.right.right.right = new TreeNode(1);

      // node.left.left = new TreeNode(11);
      // node.left.left.left = new TreeNode(7);
      // node.left.left.right = new TreeNode(2);

      // boolean xo = hasPathSum(node,22);
      // System.out.println(xo);

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        System.out.println(hasPathSum(node1,5));
    }
}
