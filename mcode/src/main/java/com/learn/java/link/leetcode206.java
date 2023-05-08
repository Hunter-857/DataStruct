package com.learn.java.link;

import java.util.Stack;

public class leetcode206 {
    /**
     *  通过stack 来旋转，要考虑题目给你一个空的list ，stack 是 empty 的情况
     * @param head
     * @return
     */
    static public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode prev = head;
        while (!stack.isEmpty()){
            ListNode  node = stack.pop();
            prev.next = new ListNode(node.val);
            prev = prev.next;
        }

        return head;
    }

    /**
     *  leetcode206  reverse List
     *  通过指针来旋转
     * @param head
     * @return
     */
    static  public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        reverseList2(node);
    }
}
