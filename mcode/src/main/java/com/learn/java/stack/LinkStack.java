package com.learn.java.stack;


public class LinkStack {

    private Node head;
    private int num;

    public LinkStack(){
        this.head = new Node();
    }

    public Node pop(){
        return this.head;
    }

    public void push(Object obj){
        Node node = new Node();
        node.data = obj;
        if(head.next !=null){
            node.next = head;
        }
        num++;
    }

    public static class Node<T>{
        T data;
        Node next;
    }
}
