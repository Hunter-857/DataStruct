package link;

import java.util.ArrayList;

public class leetcode160 {

    static class ListNode {
        int val;
        leetcode160.ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList array = new ArrayList();

        while (headA!=null){
            if(!array.contains(headA.val)){
                array.add(headA);
            }
            headA = headA.next;
        }
        while (headB !=null){
            if(array.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
