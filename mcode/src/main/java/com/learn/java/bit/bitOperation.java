package com.learn.java.bit;

import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class bitOperation {

    public static void printBit(int num){
        for (int i = 31; i > 0; i--) {
            System.out.print (
                    (num & (1 << i))==0? "0":"1"
            );
        }
    }

    // https://github.com/algorithmzuo
    public static void main(String[] args) {
        // int 32
        printBit(83928328);
    }
}
