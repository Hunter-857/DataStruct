package ag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    /**
     *  选择排序
     * @param nums
     */
    static public void selectSort(int[] nums){
        for(int i = 0 ; i < nums.length;i++){
            int min = nums[i];
            int minIndex = i;
            int j = i+1;
            for( ; j < nums.length - 1 ;j++){
                if(nums[j] < min){
                    min = nums[j];
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = min;
            nums[minIndex] = tmp;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static public List<String> generateParenthesis(int n) {
        List result = new ArrayList();
        int len = n * 2;




        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,3,1,9,24,12,57};
        selectSort(nums);

        int[] nums1 = new int[]{1,3,5,6};

    }
}
