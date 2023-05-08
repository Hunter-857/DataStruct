package arrays;
import java.util.*;


public class leetcode15 {
    /**
     *  太复杂 超时了
     *   加入list 一次 循环 N
     *   下面 for 本身两个循环 N * (N - i)
     *   contains 方法其实叶有一层循环 ——> Arraylist.contains()
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                 int two = nums[i] + nums[j];
                 ArrayList<Integer> tmp = new ArrayList();
                 List sublist =  list.subList(j+1,length);
                 if(two != 0){
                     if (sublist.contains(Math.negateExact(two))) {
                         tmp.add(nums[i]);
                         tmp.add(nums[j]);
                         tmp.add(Math.negateExact(two));
                     }
                 }else {
                     if (sublist.contains(0)) {
                         tmp.add(nums[i]);
                         tmp.add(nums[j]);
                         tmp.add(0);
                     }
                 }
                 if(tmp.size() ==3){
                     result.add(tmp);
                 }
            }
        }

        // 去重复
        HashSet<List<Integer>> set = new HashSet(result.size());
        List<List<Integer>> fianl = new ArrayList();
        for (List li : result) {
            if(set.add(li)){
                fianl.add(li);
            }
        }

        return fianl;
    }

    /**
     *  官方给的 题解： 排序加双指针
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{0};


        System.out.println(threeSum2(nums));
        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));

    }
}
