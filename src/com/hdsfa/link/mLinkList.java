package com.hdsfa.link;


import java.util.LinkedList;

/*
* Self design Single LinkList
* */
public class mLinkList {

    private Node head;

    public mLinkList(){

    }
    public mLinkList(Node node){
        this.head =node;
    }

    /**
     * Add The First Node for LinkList
     * @param node
     */
    public void addFirst(Node node){
        head = node;
    }

    /**
     * Add node at last
     * @param node
     */
    public void add(Node node){
        //临时节点
        Node temp = head;
        // 找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
    }

    /**
     * insert one Node at position
     * @param pos
     * @param nNode
     */
    public void add(int pos,Node nNode){
        int index = 0;
        while(head.next !=null){
            if (index < pos){
                head = head.next;
                index++;
            }else{
                nNode.next =head.next;
                head.next = nNode;
            }
        }
    }

    public void delete(int pos){
        int index = 0;
        while (head.next !=null){
            if (index < pos){
                head = head.next;
                index++;
            }else{
                //head = nNode;
                //nNode.next =head.next;
            }
        }
    }

    private static class Node<T> {
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        mLinkList mLinkList = new mLinkList(new Node<>(1));
        mLinkList.add(new Node(2));
        mLinkList.add(new Node(3));
        mLinkList.add(new Node(4));

        mLinkList.add(1,new Node(0));

        System.out.println(mLinkList);
    }

}
