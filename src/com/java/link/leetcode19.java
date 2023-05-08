package link;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class leetcode19 {


    static   public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    static public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public  static  ListNode removeNthFromEnd2(ListNode head, int n) {
        Queue<ListNode> queue = new ArrayDeque();
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (head!=null){
            queue.add(head);
            head = head.next;
        }
        for (int i = 1; i < queue.size() - n + 1; ++i) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return  dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        removeNthFromEnd2(head,2);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        ListNode node = removeNthFromEnd2(head2,1);

        while (node!=null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
