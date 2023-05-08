package tree;


import java.util.*;

// 自己定的 Tree Node 节点
public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     // 深度优先搜索的方式
    public void  preOrder(TreeNode node){
        if(node != null) System.out.print(node.val + " ");
        if(node!=null) preOrder(node.left);
        if(node!=null) preOrder(node.right);
    }

    public void  inOrder(TreeNode node){
        if(node!=null) inOrder(node.left);
        if(node!=null) System.out.print(node.val+ " ");
        if(node!=null) inOrder(node.right);
    }
    public void afterOrder(TreeNode node){
        if(node!=null) afterOrder(node.left);
        if(node!=null) afterOrder(node.right);
        if(node!=null) System.out.print(node.val + " ");
    }

    //借助堆栈来消除, 左边压进去，直到到左边没有了，就弹出来一个，走到右边去
    public static  void  preOrderNoRecursion(TreeNode node){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while(treeNode!=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while(treeNode != null){
                //System.out.print(treeNode.val+" ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
           // if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            //}
        }

    }

    public static void innerOderNoRecursion(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while(treeNode!=null || !stack.isEmpty()){
            while(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            System.out.print(treeNode.val+" ");
            treeNode = treeNode.right;

    }
 }

 public  static  void afterOderNoRecursion(TreeNode node){
     Stack<TreeNode> stack = new Stack<TreeNode>();
     TreeNode treeNode = node;
     TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点
     //节点不为空，结点入栈，并且指向下一个左孩子
     while(treeNode!=null || !stack.isEmpty()){
         while(treeNode!=null){
             stack.push(treeNode);
             treeNode = treeNode.left;
         }
         //栈不为空
         if(!stack.isEmpty()){
             //出栈
             treeNode = stack.pop();
             /**
              * 这块就是判断treeNode是否有右孩子，
              * 如果没有输出treeNode.data，让lastVisit指向treeNode，并让treeNode为空
              * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
              */
             if(treeNode.right == null || treeNode.right == lastVisit) {
                 System.out.print(treeNode.val + " ");
                 lastVisit = treeNode;
                 treeNode  = null;
             }else{
                 stack.push(treeNode);
                 treeNode = treeNode.right;
             }

         }

     }
 }

     //层遍历也叫广度优先遍历
    public static  List<List<Integer>> readTree(TreeNode root){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
     }




}
