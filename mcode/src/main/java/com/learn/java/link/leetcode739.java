package com.learn.java.link;

import java.util.*;

public class leetcode739 {

    /**
     *  暴力可以解决不过会超时。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int todayTemperatures = temperatures[i];
            int step = 0;
            for (int j = i+1; j < temperatures.length; j++) {
                if(todayTemperatures < temperatures[j]){
                    //next is higher
                    step++;
                    break;
                }else{
                    // not get to the end
                    for (int k = j+1 ; k < temperatures.length ; k++) {
                        if(todayTemperatures < temperatures[k]){
                            step++;
                            break;
                        }
                    }

                }
            }
            resultArr.add(step);
        }

        int[] restult = new int[resultArr.size()];
        for (int i = 0; i < resultArr.size(); i++) {
            restult[i] = resultArr.get(i);
        }
        return restult;
    }

    /**
     *  单调 stack
     *
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }


    static public void reverse(ListNode node){

        if(node.next == null )return;
        ListNode  pre = null ;
        ListNode  after = node;
        while (after!=null){
            ListNode tmp = after.next;
            after.next = pre;

            pre = after;
            after = tmp;
        }
        System.out.println(pre);
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        reverse(listNode);



    }
}
