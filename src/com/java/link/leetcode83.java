package link;

import java.util.*;

public class leetcode83 {

    /**
     * 两次循环有些慢
     */
    public ListNode deleteDuplicates(ListNode head) {
        Queue<Integer> queue =  new ArrayDeque<>();
        while (head !=null){
            int nodeValue = head.val;
            if(!queue.contains(nodeValue) || queue.isEmpty()){
               queue.add(nodeValue);
            }
            head = head.next;
        }
        ListNode result = null;
        if(!queue.isEmpty()){
             result = new ListNode(queue.poll());
            ListNode pre = result;
            while (!queue.isEmpty()){
                pre.next = new ListNode(queue.poll());
                pre = pre.next;
            }
        }

        return result;
    }

    /**
     *  因为题上说是 排序排好的，所以可以直接删除
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }



   static public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}
