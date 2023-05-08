package com.learn.java.tree;

import java.util.*;

public class leetcode51 {

    public List<List<String>> solveNQueens(int n) {
        int[][]  area = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        if(n==1){
           ArrayList list =  new ArrayList<>();
           list.add("Q");
           result.add(list);
           return result;
        }
        //dfs
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[][] used = new boolean[n][n];
        dfs(n,path,used,result);

        return result;
    }
    public static  void  dfs(int n ,Deque path,boolean[][] used,List<List<String>> result){

        // 停止条件
        if(path.size() == n){
            return;
        }

        //循环行
        for (int i = 0; i < n ; i++) {
            boolean item = used[n][n];

            boolean up = used[n-1][n];
            boolean bottom = used[n+1][n];
            boolean left = used[n][n-1];
            boolean right  = used[n][n+1];
            boolean  bottomLeft = used[n+1][n+1];
            boolean  bottomRight = used[n+1][n-1];
            boolean  upLeft = used[n-1][n+1];
            boolean  upRight = used[n-1][n+1];

        }

    }

    public static void test2() {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String x = scan.nextLine();
        HashMap<String,Integer> wordMap = new HashMap();
        for(int i = 0; i< x.length()-1;i++){
            String temp =   x.substring(i,i+1);
            if (!wordMap.keySet().contains(temp)) {
                wordMap.put(temp,1);
            }else {
                Integer value = wordMap.get(temp);
                wordMap.put(temp,value++);
            }
        }
        System.out.println(wordMap);
    }

    public static void main(String[] args) {
        test2();
    }

}
