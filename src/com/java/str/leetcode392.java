package str;

public class leetcode392 {
    // 双指针 没有啥压力
    public boolean isSubsequence(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();
        int i = 0 ,j = 0;
        while (i < sourceLen && j < targetLen ){
            char sourceChar = source.charAt(i);
            char targetChar = target.charAt(j);
            if(sourceChar == targetChar){
                i++;
                j++;
            }else {
                j++;
            }
        }
        return i == sourceLen;
    }

    public static void main(String[] args) {
        leetcode392 leetcode392  =  new leetcode392();

        boolean test = leetcode392.isSubsequence("abc","ahbgdc");
        System.out.println(test);
        //s = "axc", t = "ahbgdc"

        boolean test1 = leetcode392.isSubsequence("b","abc");
        System.out.println(test1);


        boolean test3 = leetcode392.isSubsequence("bb","ahbgdc");
        System.out.println(test3);
    }
}
