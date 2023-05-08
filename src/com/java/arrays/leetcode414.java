package arrays;

import java.util.ArrayList;
import java.util.TreeSet;


public class leetcode414 {

    /**
     *  掉包小能手。
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        list.sort((o1, o2) -> o1 > o2 ? -1 : 1);
        if(list.size()==1) return list.get(0);
        if(list.size()==2) return list.get(1);
        else {
            return  list.get(2);
        }
    }

    /**
     *  新的集合，最多有3个元素就好了
     *  我们可以遍历数组，同时用一个有序集合来维护数组中前三大的数。
     *  具体做法是每遍历一个数，就将其插入有序集合，若有序集合的大小超过 33，就删除集合中的最小元素。
     *  这样可以保证有序集合的大小至多为 33，且遍历结束后，若有序集合的大小为 33，其最小值就是数组中第三大的数；
     *  若有序集合的大小不足 33，那么就返回有序集合中的最大值。
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }


    public static void main(String[] args) {
       // int[] nums = new int[]{2, 2, 3, 1};
        //int[] nums = new int[]{3, 2, 1};
        int[] nums = new int[]{ 1, 1, 2};

        int result = thirdMax(nums);
        System.out.println(" ");
        System.out.println(result);
    }
}
