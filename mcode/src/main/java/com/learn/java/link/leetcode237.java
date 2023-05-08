package com.learn.java.link;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode237 {
    /**
     *  就是直接删除就可以了， 没有什么特别的，4的next 指向next.next
     *  4 -> 5 -> 1 -> 9
     *   4 -> 1 -> 9
     * @param listNode
     */
    public void deleteNode(ListNode listNode) {
        listNode.val = listNode.next.val;
        listNode.next = listNode.next.next;
    }

    /**
     *  leetcode 258  so easy 逻辑题
     * @param num
     * @return
     */
    static public int addDigits(int num) {
        int  result = 0;
        while (num > 0) {
            int wei =  num % 10;
            result +=wei;
            num = num / 10;
            if(result >= 10 && num == 0){
                num = result;
                result = 0;
            }
        }
        return  result;
    }

    /**
     * offer 22. 简单 easy
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curr = head;
        ArrayList<ListNode> arrayList = new ArrayList<>();

        while (curr!=null){
            arrayList.add(curr);
            curr = curr.next;
        }
        int size = arrayList.size();
        ListNode node  = arrayList.get(size -1 - k);

        return node;
    }

    /**
     *  offer 22  快慢指针 一个比较巧妙的方法
     * @param head
     * @param k
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     *  leetcode 24 强行搞定～
     */
    static public  ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        if(curr==null || curr.next == null) return curr;
        ArrayList<ListNode> list = new ArrayList();
        Stack<ListNode> stack = new Stack<>();

        while (curr!=null){
            stack.push(curr);
            if(stack.size() ==2){
                while (!stack.isEmpty()){
                    list.add(stack.pop());
                }
            }
            curr = curr.next;
        }
        ListNode dummyHeader = new ListNode(0);
        ListNode ans = dummyHeader;
        for (ListNode item :list) {
            dummyHeader.next = new ListNode(item.val);
            dummyHeader = dummyHeader.next;
        }
        while (!stack.isEmpty()){
            dummyHeader.next =stack.pop();
            dummyHeader =dummyHeader.next;
        }
        return ans.next;
    }
    public static void main(String[] args) {
        int num = addDigits(38);
        int num1 = addDigits(19);
        System.out.println(num);
        System.out.println(num1);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);


        swapPairs(head);
    }
}
