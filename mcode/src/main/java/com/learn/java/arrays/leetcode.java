package com.learn.java.arrays;


public class leetcode {

    public int[][] matrix;

    public void setZeroes2(int[][] matrix) {
        //matrix[0][0]

        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        this.matrix =matrix;
    }

    /**
     *  leetcode 1
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i]+ nums[j]== target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


}
