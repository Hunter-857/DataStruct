package com.hdsfa.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
     /*
        Definition for a binary tree node.
     * */
      public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
      }
    /*
    *  [1,null,2,3]
    *  input:    1
                   \
                    2
                   /
                  3
    *  output:[1,2,3]
    * */
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root !=null){
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
      }

    /**
     *  inorder Traver sal
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root !=null){
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root !=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }



    private List<List<Integer>> levelRead = new ArrayList<>();
    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null)
        {
            return levelRead;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> level  =  new ArrayList<>();
        TreeNode current = null;
        queue.add(root);
        while(!queue.isEmpty())
        {
            //出队队头元素并访问
            current = queue.poll();
            level.add(current.val);
            // System.out.print(current.val +"-->");
            if(queue.isEmpty()){
                levelRead.add(level);
                level = new ArrayList<>();
            }
            //如果当前节点的左节点不为空入队
            if(current.left != null)
            {
                queue.add(current.left);
            }
            //如果当前节点的右节点不为空，把右节点入队
            if(current.right != null)
            {
                queue.add(current.right);
            }

        }
        return levelRead;
    }
    public  List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(!queue.isEmpty()) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                //如果节点的左/右子树不为空，也放入队列中
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }
    @Test
    public void testSolution(){ TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        root.right =right;
        root.right.left = third;
        List list =  preorderTraversal(root);
        System.out.println(list);

        TreeNode root1 = new TreeNode(3);
        TreeNode root1_left = new TreeNode(9);
        TreeNode root1_right = new TreeNode(20);
        TreeNode second_right = new TreeNode(7);
        TreeNode second_left = new TreeNode(15);
        root1.right = root1_right;
        root1.left = root1_left;
        root1_right.left = second_left;
        root1_right.right = second_right;
        System.out.println(levelOrder2(root1));

    }
}
