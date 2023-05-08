package com.learn.java.link;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode24 {

    public static ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        int index = 1;
        Queue<ListNode> queue = new LinkedList<>();
        while (curr !=null ){
            if(index % 2 == 0){
                ListNode node  = queue.poll();
                ListNode tmp = curr.next;
                curr.next = node;
                node.next = tmp;
            }
            queue.offer(curr);
            curr = curr.next;
            index++;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        swapPairs(head);

    }
}
