package arrays;

import java.util.HashSet;
import java.util.Set;


public class leetcode350 {

    public int[] intersect(int[] source, int[] target) {

        return new int[]{1,3,3};
    }
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstring2(String s) {
        int i =0;
        HashSet hSet = new HashSet<>();
        int max = 0;
        if(s.length()==1)return 1;
        while(i < s.length()){
            char  indexChar = s.charAt(i);
            
            if(!hSet.add(indexChar)){
                max = Math.max(max, hSet.size());
                
                hSet.clear();
            }
             i++;   
        }

        return  Math.max(max, hSet.size());
    }
    public static void main(String[] args) {
        leetcode350 leetcode350 = new leetcode350();
        int[] num1 = new int[]{1,2,2,1};
        int[] num2 = new int[]{2,2};
        leetcode350.intersect(num1,num2);


        int[] num3 = new int[]{4,9,5};
        int[] num4 = new int[]{9,4,9,8,4};
        leetcode350.intersect(num3,num4);
        
        int result = leetcode350.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
        int result1 = leetcode350.lengthOfLongestSubstring("bbbbb");
        System.out.println(result1);
        int result2 = leetcode350.lengthOfLongestSubstring("pwwkew");
        System.out.println(result2);
        int result3 = leetcode350.lengthOfLongestSubstring("au");
        System.out.println(result3);
        int result4 = leetcode350.lengthOfLongestSubstring("dvdf");
        System.out.println(result4);
    }
}
