package com.learn.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class leetcode6 {

    static public String convert(String source, int numRows) {
        int len = source.length();
        String[][] result = new String[numRows][len];

        int index = 0;
        while (index < len){
            String sub = source.substring(index,index+1);
            int x =  index % numRows;

            

        }

       return "d";
    }

    public static void main(String[] args) {
        System.out.print(convert("PAYPALISHIRING", 3));
    }
}
