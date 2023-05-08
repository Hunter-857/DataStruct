package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode394 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList arrayList = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i =0 ; int j = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i]==nums2[j] && !arrayList.contains(nums1[i])){
                arrayList.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }

        }

        int[] result = new int[arrayList.size()];

        for (int k = 0; k < result.length; k++) {
            result[k] = (int) arrayList.get(k);
        }
        //Arrays.fill();
        return result;
    }

    public  static  int[]  sort(int[] nums){

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    int tmp =  nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }


        return nums;
    }
}
