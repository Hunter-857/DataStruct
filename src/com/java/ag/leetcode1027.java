package ag;

import java.util.*;

public class leetcode1027 {

    public int longestArithSeqLength(int[] nums) {
        int result = 0;
        Stack queee = new Stack();
        Deque deque = new LinkedList();
       // dfs(nums,0,new States(),queee);
        dfs2(nums,0,0, deque);

        System.out.println(queee);
        return result;
    }
    public void  dfs(int[] nums, int path, States states , Stack queen){


        if(path < -1){
            queen.remove(queen.size()-1);
            return;
        }
        if(queen.size() > 0){
            States last = (States) queen.peek();
            if (states.path != last.path) {
                queen.pop();
            }
        }
        int len = nums.length;
        for (int i = 1; i < len ; i++) {
            path = nums[i-1] - nums[i] ;
            //States states = new States();
            states.pre = nums[i-1];
            states.next = nums[i];
            states.path = path;
            queen.add(states);
            //dfs(nums,path,result,queen);
        }

    }

    public void  dfs2(int[] nums, int path,int depth , Deque deque ){

        if(path < 0 || depth < 0){
            deque.removeLast();
            return;
        }
        if(depth ==0){
            path = Math.abs(nums[1]-nums[0]);
        }
        for (int i = depth; i < nums.length-1; i++) {
            int tmpX = nums[depth];
            int tmpY = nums[depth+1];

            if (Math.abs(tmpY-tmpX) == path) {
                deque.add(tmpX);
                dfs2(nums,path,depth+1,deque);
            }

            if(depth !=0){
                deque.removeLast();
                depth--;
            }

        }


    }

    static public  class States{
        int path;
        Integer pre;
        Integer next;
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <2){
            return 0;
        }else {
            int minPrice = Integer.MAX_VALUE;
            int maxProit = 0;
            for (int i = 0; i <len ; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }else if(prices[i]-minPrice >maxProit){
                    maxProit = prices[i]-minPrice;
                }
            }
            return maxProit;
        }
    }



    public static void main(String[] args) {
        leetcode1027 solution = new leetcode1027();
        int[] nums = new int[]{3,6,9,12};
        int[] nums1 = new int[]{9,4,7,2,10};
        //solution.longestArithSeqLength(nums);
        //solution.longestArithSeqLength(nums1);
        int[] test1 = new int[]{7,1,5,3,6,4};
        int[] test2 = new int[]{1,2,3,4,5};
        int[] test3 = new int[]{7,6,4,3,1};
        System.out.println(solution.maxProfit(test1));
        System.out.println(solution.maxProfit(test2));
        System.out.println(solution.maxProfit(test3));
    }
}
