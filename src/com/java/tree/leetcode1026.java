package tree;

public class leetcode1026 {


    public int maxAncestorDiff(TreeNode root) {

        int tmp1 = Math.abs(root.val - root.right.val);
        int tmp2 = Math.abs(root.val - root.left.val);


        int max = Math.max(tmp1,tmp2);


        return max;
    }

    public static  int dfs(TreeNode node, TreeNode fatherNode, int value,int tmpMax){

        int tmp = fatherNode.val - node.val;
        if(node.right !=null){
            
        }
        if(node.left !=null){

        }

        return 0;
    }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);


    }

}
