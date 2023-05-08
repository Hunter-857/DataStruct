package tree;

import java.util.*;
import java.util.function.Consumer;

public class leetcode655 {

    // 深度优先
    static public void dfs(TreeNode root){
        // to left
        Stack<TreeNode> stack = new Stack();
        while (root!=null){
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()){
            root =stack.pop();
            System.out.print(root.val +  " "); //    root
            while (root.right != null){
                stack.push(root.right);
                root = root.right;
               // System.out.print(root.val +  " ");//right
            }

        }

    }
   static public  void innerOderNoRecursion(TreeNode listNode){
        Stack<TreeNode> stack = new Stack();
        TreeNode treeNode = listNode;
        while(treeNode!=null || !stack.isEmpty()){
            while(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            treeNode = stack.pop();
            System.out.print(treeNode.val+" ");
            treeNode = treeNode.right;
            //System.out.print(treeNode.val+" ");

        }
    }

    // 广度优先
   static public void leverfirst(TreeNode root){

    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> level = new LinkedList(); // next level
     level.offer(root);
     while (!level.isEmpty()){
         ArrayList<Integer> levelValue = new ArrayList();
         int currentSize = level.size();
         for (int i = 0; i <  currentSize ; i++) {
             TreeNode tmp = level.poll();
             levelValue.add(tmp.val);

             if(tmp.left!=null){
                 level.offer(tmp.left);
             }
             if(tmp.right!=null){
                 level.offer(tmp.right);
             }
         }
         ans.add(levelValue);
     }

       System.out.println(ans);
}

//morris遍历来遍历该树
public static void morris(TreeNode root){
    if(root == null) return;
    TreeNode curr = root;
    while (curr !=null){
        if(root.left == null){
            curr = curr.right;
            System.out.print(curr.val + " ");
        }else {
            TreeNode tmp = curr;
            while (tmp.right!=null){
                tmp = tmp.right;
            }
            TreeNode mostright = tmp;
            if (mostright.right == null){
                mostright = curr;
                curr = curr.left;
                System.out.println(curr.val);
            }
            if(mostright == curr){
                mostright = null;
                curr = curr.right;
                System.out.println(curr.val);
            }

        }
    }
}
    public static void morrisPre(TreeNode head) {
        if(head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null){
            // cur表示当前节点，mostRight表示cur的左孩子的最右节点
            mostRight = cur.left;
            if(mostRight != null){
                // cur有左孩子，找到cur左子树最右节点
                while (mostRight.right !=null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // mostRight的右孩子指向空，让其指向cur，cur向左移动
                if(mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.val+" ");
                    cur = cur.left;
                    continue;
                }else {
                    // mostRight的右孩子指向cur，让其指向空，cur向右移动
                    mostRight.right = null;
                }
            }else {
                System.out.print(cur.val + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

static public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int start = 0;
    int end = nums.length - 1;
    int ans = nums[0] + nums[1] + nums[2] ;
    while (end > start){
        if(target > ans){
            start++;
        }else {
            end --;
        }
        ans = nums[start] + nums[start+1] + nums[end];
    }
    return  ans;
}


    public static void main(String[] args) {

        int[] nums = new  int[]{-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("===dfs=");
        dfs(root);
        System.out.println();
        System.out.println("===dfs=");
        innerOderNoRecursion(root);
        System.out.println();
        leverfirst(root);
        System.out.println("========");
        morrisPre(root);
    }
}
