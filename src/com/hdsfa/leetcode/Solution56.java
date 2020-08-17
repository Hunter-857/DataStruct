package com.hdsfa.leetcode;

import org.junit.Test;

import java.util.*;

public class Solution56 {

    /**
     *
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        Stack stack = new Stack();
        for (int i = 0; i < intervals.length-1; i++) {
            int[] area1 = intervals[i];
            int[] area2 = intervals[i+1];
            if((area2[1] >=area1[0]) && (area2[1] <= area1[1]) ||
                    (area1[1] >=area2[0]) && (area1[1] <= area2[1])) {
                int[] mergeArea = {area2[0]<area1[0]?area2[0]:area1[0],
                        area1[1]>area2[1]?area1[1]:area2[1]};
                stack.add(mergeArea);
            }else {
                stack.add(area1);
            }
        }
        int[][] result  = new int[stack.size()][];
        int index = stack.size()-1;
        while (!stack.isEmpty()){
            result[index] = (int[]) stack.pop();
            index--;
        }
        return result;
    }

    /**
     *
     * @param intervals
     * @return
     */
    public int[][] merge3(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        // 按照起点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 也可以使用 Stack，因为我们只关心结果集的最后一个区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] curInterval = intervals[i];
            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            int[] peek = res.get(res.size() - 1);
            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            } else {
                // 注意，这里应该取最大
                peek[1] = Math.max(curInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    @Test
    public  void solutions() {
        int[][] nums = {
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] nums1 = {
                {1,4},{4,5}
        };
        int[][] nums2 = {
                {1,4},{1,4}
        };
        int[][] nums3 = {
                {1,4},{0,1}
        };
        int[][] nums4 = {
                {2,3},{4,5},{6,7},{8,9},{1,10}
        };
        System.out.println(merge3(nums));
        System.out.println(merge3(nums));
        System.out.println(merge3(nums4));
    }
}
