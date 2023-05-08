package str;

public class leetcode165 {

    static public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int len = Math.min(version1.length(),version2.length());
        while (i < len && j < len){
            char st1 = version1.charAt(i);
            char st2 = version2.charAt(j);

            if(st1 == '0'){
                i++;
                continue;
            }
            if(st2 == '0'){
                j++;
                continue;
            }
            if(st1 > st2){
                ans = -1;
            }else if(st1 < st2){
                ans =  1;
            }
            i++;j++;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.01", "1.00"));
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
    }
}
