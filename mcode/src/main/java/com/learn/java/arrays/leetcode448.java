package com.learn.java.arrays;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode448 {
    /**
     *  因为 new 了 一个 hashMap 所以没有符合进阶的要求，
     *  我觉得进阶的思路就是个250！！
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Integer> numsShowTimed =  new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(numsShowTimed.get(nums[i])==null){
                numsShowTimed.put(nums[i],1);
            }else {
                int value = numsShowTimed.get(nums[i]);
                numsShowTimed.put(nums[i],value++);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numsShowTimed.keySet().contains(i)) {
                arrayList.add(i);
            }
        }


        return arrayList;
    }

    /**
     *  直接向用nums作为 hash表，思路清奇
     *
     *  https://www.bilibili.com/video/BV1eg411w7gn?p=10
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
    
    // leetcode219
    static public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j =  Math.abs(i - k+1) ;
           
            // i <= j + K   =>  j >= i -k
            while(j > i & j > 0){
                if(nums[j]==nums[i]){
                    return  Math.abs(i-j) <= k;
                }
                j--;
            }

        }


        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsNearbyDuplicate(nums,3));
        
        int[] nums1 = new int[]{1,0,1,1};
        System.out.println(containsNearbyDuplicate(nums1,1));
        

        int[] nums2 = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums2, 2));

        int[] nums3 = new int[]{99,99};
        System.out.println(containsNearbyDuplicate(nums3, 2));
    }
}

/*
 *   
 
-XX:ReservedCodeCacheSize=240m
-XX:+UseConcMarkSweepGC
-XX:SoftRefLRUPolicyMSPerMB=50
-ea
-XX:CICompilerCount=2
-Dsun.io.useCanonPrefixCache=false
-Djdk.http.auth.tunneling.disabledSchemes=""
-XX:+HeapDumpOnOutOfMemoryError
-XX:-OmitStackTraceInFastThrow
-Djdk.attach.allowAttachSelf=true
-Dkotlinx.coroutines.debug=off
-Djdk.module.illegalAccess.silent=true
-XX:+UseCompressedOops
-Dfile.encoding=UTF-8
-XX:ErrorFile=$USER_HOME/java_error_in_idea_%p.log
-XX:HeapDumpPath=$USER_HOME/java_error_in_idea.hprof
 * 
 */