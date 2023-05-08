package str;

import java.util.*;

public class leetcode3 {

    /**
     *  leetcode 169  , 两次循环比较慢
     * @param nums
     * @return
     */
    static public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.keySet().contains(nums[i])){
                int values = hashMap.get(nums[i]);
                hashMap.put(nums[i],++values);
            }else {
                hashMap.put(nums[i],1);
            }
        }
        int max = -1;
        int result = -1;
        Integer[] keyArray = hashMap.keySet().toArray(new Integer[0]);
        for (int i = 0; i <keyArray.length; i++) {
            System.out.println(hashMap.get(keyArray[i]));
            if(hashMap.get(keyArray[i]) > max){
                result = keyArray[i];
                max = hashMap.get(keyArray[i]);
            };
        }

        return result;
    }

    /**
     *  leetcode 219  暴力解法，执行时间超出时间
     * @param nums
     * @param k
     * @return
     */
    static  public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            int j = i+1;
            while (j < len){
                if(nums[i] == nums[j] && Math.abs(i-j) <= k){
                    return  true;
                }
               j++;
            }
        }
        return false;
    }

    /**
     *  借助HashSet 实现滑动窗口
     * @param nums
     * @param k
     * @return
     */
    static  public boolean containsNearbyDuplicate2(int[] nums, int k) {

        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {// set add fail return false
                return true;
            }
        }
            return false;
    }
    static public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    /**
     *  leetcode 6
     *    其实就是个找规律的题， 对应几行就是数组长度，
     *    判断是否要 就将某个位置设置成字母或 空字符
     * @param s
     * @param numRows
     * @return
     */

    static public String convert(String s, int numRows) {

        if(numRows == 1)
            return s;

        int len = Math.min(s.length(), numRows);
        String []rows = new String[len];
        for(int i = 0; i< len; i++) rows[i] = "";
        int loc = 0;
        boolean down = false;

        for(int i=0;i<s.length();i++) {
            rows[loc] += s.substring(i,i+1);
            if(loc == 0 || loc == numRows - 1)
                down = !down;
            loc += down ? 1 : -1;
        }

        String ans = "";
        for(String row : rows) {
            ans += row;
        }

        return ans;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        HashMap<String,String> keyBoard = new HashMap();
        keyBoard.put("2","abc");
        keyBoard.put("3","def");
        keyBoard.put("4","ghi");
        keyBoard.put("5","jkf");
        keyBoard.put("6","mno");
        keyBoard.put("7","pqrs");
        keyBoard.put("8","tuv");
        keyBoard.put("9","wxyz");
        if("".equals(digits)) return ans;

       // ArrayList<char[]>  letterArr = new ArrayList<>();

        ArrayList<char[]> letterArrs = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String  letter =  keyBoard.get(digits.substring(i,i+1));
            letterArrs.add( letter.toCharArray());
        }

        int index = 1;
        for (int i = 0; i < letterArrs.size(); i++) {
            char[] tmp  =  letterArrs.get(i);
            StringBuilder builder = null;

            while (index < letterArrs.size()){
                builder = new StringBuilder();
                builder.append(tmp[i]);
                char[] next = letterArrs.get(index);
                builder.append(next[i]);
                index++;
            }
            ans.add(builder.toString());
        }

        return  ans;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{3,2,3};
        int[] nums = new int[]{1,2,1};

        System.out.println(containsNearbyDuplicate2(nums,1));
        // PAYPALISHIRING", numRows = 3

        String ans  = convert("PAYPALISHIRING",3);
        System.out.println(ans);
        List list = letterCombinations("23");

        System.out.println(list);
    }
}
