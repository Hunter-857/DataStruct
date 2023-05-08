package com.learn.java.ag;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class leetcode2404 {

    public  static int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2 == 0){
              if(hashMap.containsKey(nums[i])){
                  Integer value = hashMap.get(nums[i]);
                  hashMap.put(nums[i],++value );
              }else {
                  hashMap.put(nums[i],1);
              }
            }
        }
        AtomicInteger minValue = new AtomicInteger();
        minValue.set(-1);
        AtomicInteger keyValue = new AtomicInteger();
        keyValue.set(-1);
        hashMap.forEach((key, value) -> {
            if(value > minValue.get()){
                minValue.set(value);
                keyValue.set(key);
            }else if (value == minValue.get()){
                keyValue.set(Math.min(key,keyValue.get()));
            }
        });
        System.out.println(hashMap);
        return keyValue.get();
    }
    // 数组的哈希
    public int mostFrequentEven2(int[] nums) {
        // 哈希表
        int[] arr = new int[100001];
        //最大频次
        int max= Integer.MIN_VALUE;
        // 元素值 默认为-1
        int maxIndex = -1;
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //非偶数元素不用处理
            if (nums[i]%2==1){
                continue;
            }
            //元素出现的频次加1
            arr[nums[i]]++;
            //频次比之前记录的都大，更新最大值和元素值
            if (max<arr[nums[i]]){
                max=arr[nums[i]];maxIndex= nums[i];
            }else if (max==arr[nums[i]]&&maxIndex> nums[i]){
                //出现频次相同 取最小元素
                maxIndex= nums[i];
            }
        }
        return maxIndex;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,2,2,4,4,1};
        System.out.println(mostFrequentEven(nums));
        int[] nums2 ={4,4,4,9,2,4};
        System.out.println(mostFrequentEven(nums2));
        int[] nums3 ={29,47,21,41,13,37,25,7};
        System.out.println(mostFrequentEven(nums3));
        int[] nums4 ={0,0,0,0};
        System.out.println(mostFrequentEven(nums4));

        int[] nums5 ={8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};
        System.out.println(mostFrequentEven(nums5));

    }
}
