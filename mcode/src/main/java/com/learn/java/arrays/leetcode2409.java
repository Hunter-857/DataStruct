package com.learn.java.arrays;

public class leetcode2409 {
    /**
     * 方法一：分别计算出每个日子是一年中的第几天后求差
     * 思路
     *
     * 我们可以设计一个函数
     * calculateDayOfYear
     * calculateDayOfYear 来计算输入中的每个日子在一年中是第几天。计算输入中的每个日子在一年中是第几天时，
     * 可以利用前缀和数组来降低每次计算的复杂度。知道每个日子是一年中的第几天后，
     * 可以先通过比较算出两人到达日子的最大值，离开日子的最小值，然后利用减法计算重合的日子。
     * @param arriveAlice
     * @param leaveAlice
     * @param arriveBob
     * @param leaveBob
     * @return
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] datesOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefixSum = new int[13];
        for (int i = 0; i < 12; i++) {
            prefixSum[i + 1] = prefixSum[i] + datesOfMonths[i];
        }

        int arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
        int leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
        int arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
        int leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);
        return Math.max(0, Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
    }

    public int calculateDayOfYear(String day, int[] prefixSum) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));
        return prefixSum[month - 1] + date;
    }




    public static void main(String[] args) {

    }
}
