package str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class leetcode728 {

    // 这个题垃圾
    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> arraylist = new ArrayList();

        for (int i = left; i < right +1 ; i++) {
           boolean is =  isNumber(i);
           if(is){
               arraylist.add(i);
           }
        }


        return arraylist;
    }

    /**
     *  leetCode 796
     *    构造 source 的两倍 ， 在构造字符串里 寻找target
     * @param s
     * @param goal
     * @return
     */
    public  static  boolean rotateString(String s, String goal) {
            String bulidSource = s + s;
            if(s.length() !=goal.length()) return false;
            int i = 0;
            for (; i < s.length() ; i++) {
                if(bulidSource.charAt(i) == goal.charAt(0)){
                    if(bulidSource.substring(i,i+ s.length()).equals(goal)){
                        return true;
                    }
                }
            }
            return false;
    }

    static  public boolean isAnagram(String s, String t) {
        if (s.length() !=t.length()) return  false;
        // anagram
        // nagaram
        HashMap<String,Integer> sourceHashMap = new HashMap<>();
        HashMap<String,Integer> targetHashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String key = Character.toString(s.charAt(i));
            String keyTarget = Character.toString(t.charAt(i));
            if(sourceHashMap.containsKey(key)){
                Integer tmp = sourceHashMap.get(key);
                sourceHashMap.put(key,++tmp);
            }else {
                sourceHashMap.put(key,1);
            }

            if(targetHashMap.containsKey(keyTarget)){
                Integer tmp = targetHashMap.get(keyTarget);
                targetHashMap.put(keyTarget,++tmp);
            }else {
                targetHashMap.put(keyTarget,1);
            }
        }
       AtomicBoolean ans = new AtomicBoolean(true);
       sourceHashMap.forEach((s1, integer) -> {
           if(targetHashMap.containsKey(s1)){
              if(!targetHashMap.get(s1).equals(integer)){
                  ans.set(false);
              }
           }else {
               ans.set(false);
           }
       });


        return ans.get();
    }

    public static boolean isNumber(int num){
        boolean result = true;
        int tmp = num;
        while (tmp > 0){
            int wei =  tmp % 10;
            if(wei ==0){
                result = false;
                break;
            }else {
                if(num % wei != 0){
                    result =false;
                    break;
                }
            }
            tmp = tmp /10 ;
        }
        return  result;
    }

    public static void main(String[] args) {

        System.out.println(rotateString("abcde", "cdeab"));
        //  "abcde", goal = "abced"
        System.out.println(rotateString("abcde", "abced"));
        // "bbbacddceeb"  "ceebbbbacdd"
        System.out.println(isAnagram("anagram", "nagaram"));

    }
}
