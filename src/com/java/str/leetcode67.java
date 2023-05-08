package str;


import java.util.HashMap;

public class leetcode67 {

    /**
     * 只出现一次的数字 II
     * 只出现一次的数字 III
     * 数组中两个数的最大异或值
     * 重复的DNA序列
     * 最大单词长度乘积
     * 我们可以设计这样的算法来计算：
     *
     * 把 aa 和 bb 转换成整型数字 xx 和 yy，在接下来的过程中，xx 保存结果，yy 保存进位。
     * 当进位不为 00 时
     * 计算当前 xx 和 yy 的无进位相加结果：answer = x ^ y
     * 计算当前 xx 和 yy 的进位：carry = (x & y) << 1
     * 完成本次循环，更新 x = answer，y = carry
     * 返回 xx 的二进制形式
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }





    public static int romanToInt(String str) {
        HashMap<String,Integer> map =  new HashMap();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            String item = str.substring(i,i+1);
            Integer value1 = map.get(item);
            if(i < str.length()-1){
                String nextItem = str.substring(i+1, i+2);
                Integer value2 = map.get(nextItem);
                if("I".equals(item)){
                    if(nextItem.equals("V") || nextItem.equals("X")){
                        sum += value2-value1;
                    }
                }else if("X".equals(item)){
                    if(nextItem.equals("L") || nextItem.equals("C")){
                        sum += value2-value1;
                    }
                }else if("C".equals(item)){
                    if(nextItem.equals("D") || nextItem.equals("M")){
                        sum += value2-value1;
                    }
                }else {
                    sum +=value1;
                }
            }else {
                sum +=value1;
            }
        }

        return sum;
    }


    public boolean isMonotonic(int[] nums) {
        boolean result = false;
        int delta = 0;

        int x  = nums[0] - nums[1];
        if(x < 0){
            System.out.println("native");
        }else {
            System.out.println("Postive");
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= nums[i+1]  ){

            }
        }
        return false;
    }


    public static void main(String[] args) {
        addBinary("11","1");
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));

    }
}
