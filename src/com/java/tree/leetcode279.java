package tree;

import java.util.*;

public class leetcode279 {


    public  static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//最坏的情况都是由1的平方组成
            for (int j = 1; j * j <= i; j++) {
                //动态规划公式
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    // BFS  多叉树遍历
    public static int numSquares1(int n) {
        Queue<Integer> queue = new LinkedList<>();
        //记录访问过的节点值
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        //树的第几层
        int level = 0;
        while (!queue.isEmpty()) {
            //每一层的节点数量
            int size = queue.size();
            level++;
            //遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                //节点的值
                int digit = queue.poll();
                //访问当前节点的子节点，类比于二叉树的左右子节点
                for (int j = 1; j <= n; j++) {
                    //子节点的值
                    int nodeValue = digit + j * j;
                    //nodeValue始终是完全平方数的和，当他等于n的
                    //时候直接返回
                    if (nodeValue == n)
                        return level;
                    //如果大于n，终止内层循环
                    if (nodeValue > n)
                        break;
                    if (!visited.contains(nodeValue)) {
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }
        return level;
    }

    // deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    public int openLock(String[] deadends, String target) {
        return 1;
    }


    public static void main(String[] args) {
          //numSquares(12);
          numSquares1(12);

        
    }
}
