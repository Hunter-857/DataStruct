package com.learn.java.ag;

public class leetcode1137 {

   static public int tribonacci(int n) {
        int t_0 = 0 ,t_1 =1 ,t_2 =1;
        int t_3 = t_0 + t_1 + t_2 ;
        if(n==0){return t_0;}
        if(n==1){return t_1;}
        if(n==2){return t_2;}
        if(n ==3 ){return  t_0 + t_1 + t_2;}
        for (int i = 3; i < n; i++) {
            t_0 = t_1;
            t_1 = t_2;
            t_2 = t_3;
            t_3 = t_0 + t_1 + t_2;
        }
        return t_3;
    }

    public static void main(String[] args) {


        System.out.println(tribonacci(25));
        System.out.println(tribonacci(4));

    }
}
