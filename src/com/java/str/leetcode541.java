package str;


import java.util.HashMap;
import java.util.Map;

public class leetcode541 {
    //输入：s = "abcdefg", k = 2
    //输出："bacdfeg"
    public static  String reverseStr(String s, int k) {
        int length = s.length();
        int remindLen = length - k;
        StringBuilder builder = new StringBuilder();
        String sub ;
        if(remindLen >= k && remindLen < 2* k){
            sub = s.substring(k, length);
            builder.append(sub).reverse();
            builder.append(sub);
        }else if(remindLen < k || remindLen >= 2 * k ){
            String remind = s.substring(k,length);
            sub = s.substring(0, k);
            builder.append(sub).reverse();
            builder.append(remind);
        }

        return builder.toString();
    }



    // 位运算
    public String toHex2(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i --) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }


   static public String toHex(int num) {
        StringBuilder builder = new StringBuilder();
        num = Math.abs(num);
        while (num >0){
            int last  = num % 16;

            if(last < 10){
                builder.append(last);
            }else {
                char tmp = (char)('a' + (last-10));
                builder.append(tmp);
            }
            num= num/16;
        }
        return builder.reverse().toString();
    }


    /**
     *  leetcode 415
     *
     *  长短不一样的字符串 循环的时候 也不用找最短的了
     *  循环条件 搞成两个字符串求 &&
     *
     *  例如  i < s1.length && i < s2.length
     */
    public static String addStrings2(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        while (l1 >= 0 || l2 >= 0) {
            int x = l1 < 0 ? 0 : num1.charAt(l1) - '0';
            int y = l2 < 0 ? 0 : num2.charAt(l2) - '0';

            int sum = x + y + carry;
            res.append(sum % 10);
            carry = sum / 10;

            l1--;
            l2--;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    /**
     * leetcode 8  我是直接根据逻辑，循环之后判断。
     * Integer.MAX_VALUE 和 Integer.MIN_VALUE 来处理上下界。
     * @param s
     * @return
     */

    static public int myAtoi(String s) {
        int sign = 1;
        int res = 0;
        int m = s.length();
        int i = 0;
        while(i < m && s.charAt(i)==' '){
            i++;
        }
        int start = i;
        for(; i < m; i++){
            char c = s.charAt(i);
            if(i==start && c=='+'){
                sign = 1;
            }else if(i==start && c=='-'){
                sign = -1;
            }else if(Character.isDigit(c)){
                int num = c-'0';
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }

                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 &&-num<Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                res = res*10+sign*num;
            }else{
                break;
            }
        }
        return res;
    }

    /**
     *  leetcode 8  官方给的一个DFA算法，
     *  有些神经病啊。。
     * @param str
     * @return
     */
    public int myAtoi2(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
        System.out.println(reverseStr("abcd",2));
        System.out.println(reverseStr("abcdefg",2));

        //System.out.println(toHex(26));

        System.out.println(addStrings2("11", "123"));
        System.out.println(addStrings2("456", "77"));
        System.out.println(addStrings2("0", "0"));
        System.out.println(addStrings2("1", "9"));
        System.out.println(addStrings2("99", "9"));
        System.out.println(addStrings2("9133", "0"));

        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("words and 987"));
    }



}
