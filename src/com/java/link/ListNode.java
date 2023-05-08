package link;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void deleteNode(ListNode node,ListNode head) {
        ListNode curr = head;
        while (curr !=null){
            if(curr.val == node.val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }

        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode after = head;
        while (after !=null){
            ListNode tmp = after.next;
            after.next = pre;

            pre = after;
            after = tmp;

        }

        return  pre;
    }

}
