package com.hdsfa.leetcode;

import org.junit.Test;

public class Solution724 {

    public int pivotIndex(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int sum = 0, result = -1;
        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];
        }
        int preSum = 0;
        for (int j = 0; j < nums.length ; j++) {
            int endValue = sum - preSum -nums[j];
            if(preSum == endValue){ result = j;break;}
            preSum +=nums[j];
        }
        return result;
    }

    @Test
    public  void solutions() {
        //test cases
        int[] number1= {1, 2, 3};
        int[] number2= {1, 7, 3, 6, 5, 6}; //3
        int[] number3= {-1,-1,-1,-1,-1,-1};
        int[] number4= {-1,-1,-1,0,1,1};//0
        int[] number5= {-1,-1,0,1,1,0};//5

    }
}
