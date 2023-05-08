package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class leetcode18 {

    static public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result= new ArrayList<>();
        for (int i = 0; i < length; i++) {

            int numI = nums[i];
            int subI = target - numI;
            for (int j = 1; j < length ; j++) {
                int numJ = nums[j];
                int subJ = subI -numJ;
                for (int k = 2; k < length; k++) {
                    int numK = nums[k];
                    int subK = subJ -numK;
                    for (int q = 3; q < length; q++) {
                            ArrayList<Integer> tmp = new ArrayList();
                            int numQ = nums[q];
                            int subQ = subK -numQ;
                            if(subQ == 0){
                                tmp.add(i);
                                tmp.add(j);
                                tmp.add(k);
                                tmp.add(q);
                                if(dupValue(tmp)){
                                    ArrayList<Integer> find = new ArrayList<>();
                                    find.add(numI);
                                    find.add(numJ);
                                    find.add(numK);
                                    find.add(numQ);
                                    result.add(find);
                                }
                                break;
                            }
                        }
                    }
                }

            }
        System.out.println(result);
        return result;
    }

    public static boolean dupValue(ArrayList<Integer> list){
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }


        return set.size() == list.size();
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        fourSum(nums,0);
    }
}
