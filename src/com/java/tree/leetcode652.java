package tree;

import java.util.ArrayList;
import java.util.List;

public class leetcode652 {

    public  static List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> ans = new ArrayList<>();
        if(root.right!=null && root.left !=null){

            if (root.right.val == root.left.val){
                ans.add(root.right);
            }else {
                 findDuplicateSubtrees(root.right);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.right = new TreeNode(3);

         root.right.right = new TreeNode(4);
         root.left.left = new TreeNode(4);
         root.right.left = new TreeNode(2);
         root.right.left.left = new TreeNode(4);


         findDuplicateSubtrees(root);
    }
}
