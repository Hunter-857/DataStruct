package tree;

import java.util.*;
import java.util.function.IntPredicate;

public class leetcode46 {

    /**
     *
     * @param nums
     * @return
     */
    static public List<List<Integer>> permute(int[] nums) {
        List result = new ArrayList();
        List inner = new ArrayList();

        for (int num : nums) {
            inner.add(num);
        }

        int n = nums.length;
        backtrack(n, inner, result, 0);

        return result;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first){
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }


    }

    static public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int len = nums.length;
        if(len==0){return  result;}

        //开始深度优先遍历。
        Deque<Integer> stack = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,stack,result,used);

        return result;
    }
    public static  void dfs(int[] nums,int depth,Deque path,List<List<Integer>> result,boolean[] used){
        if(depth == nums.length){
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] =true;
            dfs(nums,depth+1,path,result,used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List result = permute(nums);
        System.out.println(result);

        int[] nums1 = new int[]{1,2,3};
        List result1 = permute1(nums);
        System.out.println(result1);

    }
}
