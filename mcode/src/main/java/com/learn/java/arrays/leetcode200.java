package com.learn.java.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode200 {


    // 深度优先遍历的题目
    public int numIslands(char[][] grid) {

        int depth = grid.length;
        int width = grid[0].length;
        int count = 0;

        ArrayList list = new ArrayList();
        for (int i = 0; i < depth; i++) {
            List list1 = godepth(new ArrayList(),width,grid,i);
            list.add(list1);
        }

        System.out.println(list);
        System.out.println(list.size());
        return count;
    }

    public List godepth(List list,int width,char[][] grid,int i){
        Stack<point> stack = new Stack<>();
        for (int j = 0; j < width; j++) { //向下
            if(i > 0 && j > 0){
                if(grid[i][j-1] =='1'){
                    stack.add(new point(i, j));
                    list.add(new point(i, j));
                }
            }else {
                if(grid[i][j] == '1'){
                    stack.add(new point(i,j));
                    list.add(new point(i,j));
                }
            }

        }
        point point = null;
        while (!stack.isEmpty()){
            point =  stack.pop();
        }
        if (point != null) {//向右
            if( point.j+1 < width && grid[point.i][point.j+1] == '1'){
                //godepth(list,width,grid,i);
                i++;
            }
        }
        return list;
    }

    class point{
        public int i,j;
        public point(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "point : {" +
                    "i=" + i + ", j=" + j + '}';
        }
    }

    /**
     *
     *  这个方法也有一个问题 ，他破坏了原有的数组结构。
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        //边界条件判断
        if (grid == null || grid.length == 0)
            return 0;
        //统计岛屿的个数
        int count = 0;
        //两个for循环遍历每一个格子
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                //只有当前格子是1才开始计算
                if (grid[i][j] == '1') {
                    //如果当前格子是1，岛屿的数量加1
                    count++;
                    //然后通过dfs把当前格子的上下左右4
                    //个位置为1的都要置为0，因为他们是连着
                    //一起的算一个岛屿，
                    dfs(grid, i, j);
                }
            }
        //最后返回岛屿的数量
        return count;
    }

    //这个方法会把当前格子以及他邻近的为1的格子都会置为1
    public void dfs(char[][] grid, int i, int j) {
        //边界条件判断，不能越界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        //把当前格子置为0，然后再从他的上下左右4个方向继续遍历
        grid[i][j] = '0';
        dfs(grid, i - 1, j);//上
        dfs(grid, i + 1, j);//下
        dfs(grid, i, j + 1);//左
        dfs(grid, i, j - 1);//右
    }
   static public int maxArea(int[] height) {
       int length =  height.length;
       int ans = 0;

        for (int i = 0; i < length; i++) {
            int end = length - 1;
            while (i < end){
                int tmp = Math.min(height[end],height[i]);
                int area =   tmp * (end - i );
                ans = Math.max(ans,area);
                if (height[i] < height[end]) {
                    end--;
                }else {
                    end--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        // System.out.println(maxArea(height));

        int[] height1 = new int[]{1,2};
        System.out.println(maxArea(height1));

    }


}
