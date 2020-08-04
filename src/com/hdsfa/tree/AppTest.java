package com.hdsfa.tree;

public class AppTest {

    public static void main(String[] args) {
        Object a = new Object() ;
        Object b = new Object();

        new Thread(() -> {
            synchronized (a){
                System.out.println(Thread.currentThread().getName() + "get a" + a);
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "get b" + b);
                }
            }

        }).start();

        new Thread(() -> {
            synchronized (b){
                System.out.println(Thread.currentThread().getName() + "get b" + b);
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "get a" + a);
                }
            }
        }).start();
    }
}
