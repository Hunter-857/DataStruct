package com.hdsfa.link;


import java.util.LinkedList;

/*
* Self design Single LinkList
* */
public class MLinkList<T> {

    private Node head;

    public MLinkList(){
        this.head = new Node(0);
    }

    public MLinkList(Node node){
        this.head =node;
    }

    /**
     * Add The First Node for LinkList
     * @param node new node
     */
    public void addFirst(Node node){
        head = node;
    }
    /**
     * Add node at last
     * @param node
     */
    public void add(Node node){
        Node temp = head;
        // find the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
    }

    /**
     * insert one Node at position
     * @param pos  position of element
     * @param nNode new Node insert
     */
    public void add(int pos,Node nNode){
        int index = 0;
        Node tmp = head;
        while(tmp !=null && index == pos){
                tmp = tmp.next;
                index++;
        }
        nNode.next =tmp.next;
        tmp.next = nNode;
    }

    /**
     *
     * @param pos
     */
    public void delete(int pos){
        int index = 0;
        Node tmp = head;

        while (tmp.next != null && index != pos){
            tmp = tmp.next;
            index++;
        }

    }

    /**
     *
     * @param <T>
     */
    public void update(int pos, T  data){
        int index = 0;
        Node tmp = head;
        while (pos != index){
            index++;
            tmp = tmp.next;
        }
        tmp.data = data;
    }
    private static class Node<T> {
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
     public static MLinkList mergeTwoLists(MLinkList l1, MLinkList l2) {
        MLinkList nMLinklist = new MLinkList();
        Node tmp1 = l1.head;
        Node tmp2 = l2.head;

         int capacity = 0 ;
         while (tmp1 !=null || tmp2  !=null){
             int result = 0;
            result = (Integer)tmp1.data + (Integer)tmp2.data;
            Node nNode ;
            int data = result % 10;
            if(result / 10 > 0){
                capacity++;
                nNode = new Node(data);
                nMLinklist.add(nNode);
            }else {
                nNode = new Node(data + capacity);
                nMLinklist.add(nNode);
                capacity = 0;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        return nMLinklist;
    }

    public static void main(String[] args) {
        MLinkList mLinkList = new MLinkList(new Node<>(1));
        mLinkList.add(new Node(2));
        mLinkList.add(new Node(9));
        System.out.println(mLinkList);

        MLinkList mLinkList1 = new MLinkList(new Node<>(1));
        mLinkList1.add(new Node(3));
        mLinkList1.add(new Node(8));

        LinkedList linkedList;
        MLinkList m3 = mergeTwoLists(mLinkList1,mLinkList);
        System.out.println(m3);
     }

}
