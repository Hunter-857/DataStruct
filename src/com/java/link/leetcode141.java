package link;


import java.util.ArrayList;


public class leetcode141 {
    /**
     *
     *  居然过了 呵呵
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        ArrayList arrayList = new ArrayList<>();
        while (head !=null){

            arrayList.add(head);
            if(arrayList.contains(head.next)){
                return true;
            }
            head = head.next;
        }

        return false;
    }

    /**
     *  for leetCode 141
     * @param head
     * @return
     */
    public int hasCycleNode(ListNode head) {

        ArrayList arrayList = new ArrayList<>();
        while (head !=null){

            arrayList.add(head);
            if(arrayList.contains(head.next)){
                //arrayList.indexOf(head.next);
                return arrayList.indexOf(head.next);
            }
            head = head.next;
        }

        return -1;
    }



}
