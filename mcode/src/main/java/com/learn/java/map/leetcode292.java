package com.learn.java.map;

public class leetcode292 {

    public boolean canWinNim(int n) {
        if (n==1)return true;

        while (n >3){
            n = n - 1 ;
            n = n - 2 ;
            n = n - 3 ;
        }

        return false;
    }
}
