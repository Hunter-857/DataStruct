package com.hdsfa.tree;

public class AppTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new DevThread()).start();
        }
    }
}
