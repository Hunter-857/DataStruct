package com.learn.java.stack;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode12 {
    /**
     * leetcode 12.
     *  一次通过了 老子也是要面子好不。哈哈
     *
     */
    HashMap<Integer,String> hashMap = new HashMap<>();
    {

        hashMap.put(1,"I");
        hashMap.put(5,"V");
        hashMap.put(10,"X");
        hashMap.put(50,"L");
        hashMap.put(100,"C");
        hashMap.put(500,"D");
        hashMap.put(1000,"M");
    }
    public String intToRoman(int num) {
        String result = "";
        int tmp = num;
        int level = 1;
        while (tmp > 0){
            int wei = tmp % 10;
            result =  getString(wei , level) + result ;
            tmp = tmp/10;
            level = level * 10;
        }
        return result;
    }

    public String getString(int num, int level){
        String result = "";
        String singleLevel  =  hashMap.get(level);
        String fiveLev  =  hashMap.get(level * 5 );
        String tenLevLev  =  hashMap.get(level * 10);
        if(num <= 3){
            for (int i = 0; i < num; i++) {
                result = result  + singleLevel;
            }
        }else if(num == 4){
            result = singleLevel +  fiveLev;
        }else if(num <9) {
            for (int i = 0; i < num-5; i++) {
                result = result + singleLevel;
            }
            result = fiveLev + result;
        }else {
            result = singleLevel + tenLevLev;
        }
        return  result;
    }

    /**
     *  官网给的题解，做减法
     *   1994 - 1000 = 994
     *
     *  两个数组当作 key-map
     *
     *   1000 -> M
     *   900  -> CM
     *   500  -> D
     *   400  -> CD
     *
     * @param args
     */
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    /**
     *  DFS
     *  L200. 岛屿数量 （Easy）
     *  L463. 岛屿的周长 （Easy）
     *  L695. 岛屿的最大面积 （Medium）
     *  L827. 最大人工岛 （Hard）
     * @param grid
     * @return
     */
    static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0'; // 访问过的节点标记成为 '0' 可以避免重复访问
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    static public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }

    public static void main(String[] args) {
        leetcode12 leetcode12 = new leetcode12();
        System.out.println(leetcode12.intToRoman2(3));
        System.out.println(leetcode12.intToRoman2(58));
        System.out.println(leetcode12.intToRoman2(9));
        System.out.println(leetcode12.intToRoman2(1994));

       char[][] grid = {
               {'1','1','1','1','0' },
               {'1','1','0','1','0' },
               {'1','1','0','0','0' },
               {'0','0','0','0','0' }
       };

       numIslands(grid);
    }
}
