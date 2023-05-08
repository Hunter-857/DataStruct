package str;

public class leetcode389 {

    public static char findTheDifference(String str, String tstr) {
        if("".equals(str)) return tstr.toCharArray()[0];
        char[] strArray = str.toCharArray();
        char[] tstrArray = tstr.toCharArray();
        int i = 0;
        for (; i < strArray.length; i++) {
            if(str.indexOf(tstrArray[i]) < 0){
                break;
            }
        }
        return tstrArray[i];
    }

    /**
     *   方法二：求和
     * 将字符串 ss 中每个字符的 ASCII 码的值求和，得到 A_sA
     *  ；对字符串 tt 同样的方法得到 A_tA
     *  。两者的差值 A_t-A_sA
     *   即代表了被添加的字符。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }



    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","abcdw"));
    }
}

