package com.hdsfa.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DevThread implements Runnable {
    private static Map<Integer, Integer> map = new HashMap<>(2);

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (atomicInteger.get() < 100000){
            map.put(atomicInteger.get(),atomicInteger.get());
            atomicInteger.incrementAndGet();
        }
    }
}
