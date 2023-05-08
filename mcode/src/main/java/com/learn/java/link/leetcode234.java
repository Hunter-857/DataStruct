package com.learn.java.link;

import java.util.ArrayList;
import java.util.List;

public class leetcode234 {
    /**
     * leetcode 234
     *  一次就过了，～ 垃圾 哈哈
     * @param head
     * @return
     */
   static public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (curr !=null){
            arrayList.add(curr.val);
            curr = curr.next;
        }

       for (int i = 0; i < (arrayList.size() / 2) ; i++) {
           if(arrayList.get(i) != arrayList.get( arrayList.size()-1 - i )){
              return  false;
           }
       }
        return true;
    }

    /**
     *  leetcode 234 同第一个方法不同的地方
     *  是在循环的时候从尾部开始
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();
        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


    /**
     *  leetcode 876  取链表的一半
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr !=null){
            curr =  curr.next;
            length++;
        }
        int i = 0;
        while (i < length/2){
            head = head.next;
            i++;
        }
        return head ;
    }

    /**
     *  leetcode 876  将Node 放入到数组中，数组长度取一半
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next= new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
