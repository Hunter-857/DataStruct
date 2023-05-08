package str;


import java.util.HashMap;

public class leetcode125 {
    /**
     *  so easy
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        String sgood = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood = sgood + Character.toLowerCase(ch);
            }
        }
        StringBuffer sgoodRev = new StringBuffer(sgood).reverse();
        return sgood.equals(sgoodRev.toString());
    }

    /**
     *  leetcode 186  利用Hash Map
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber) {
        HashMap<Integer,String> hashMap =  new HashMap();
       // hashMap.put(0,"Z");
        hashMap.put(1,"A");
        hashMap.put(2,"B");
        hashMap.put(3,"C");
        hashMap.put(4,"D");
        hashMap.put(5,"E");
        hashMap.put(6,"F");
        hashMap.put(7,"G");
        hashMap.put(8,"H");
        hashMap.put(9,"I");
        hashMap.put(10,"J");
        hashMap.put(11,"K");
        hashMap.put(12,"L");
        hashMap.put(13,"M");
        hashMap.put(14,"N");
        hashMap.put(15,"O");
        hashMap.put(16,"P");
        hashMap.put(17,"Q");
        hashMap.put(18,"R");
        hashMap.put(19,"S");
        hashMap.put(20,"T");
        hashMap.put(21,"U");
        hashMap.put(22,"V");
        hashMap.put(23,"W");
        hashMap.put(24,"X");
        hashMap.put(25,"Y");
        hashMap.put(26,"Z");
        StringBuilder stringBuilder = new StringBuilder();

        while (columnNumber > 0){
            int digit = columnNumber % 26;
            if(digit == 0) {
                stringBuilder.append(hashMap.get(26));
            } else {
              stringBuilder.append(hashMap.get(digit));
            }
            columnNumber = (columnNumber - digit)/ 26;
        }

        return stringBuilder.reverse().toString();
    }

    /**
     *  利有 char
     * @param columnNumber
     * @return
     */
    public static  String convertToTitle2(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 ;
            sb.append((char)(a0 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }

    // leetcode 171   2 * 26^2 + 1 * 26^ 0
    public static int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char chr =  columnTitle.charAt(i);
            int num =  (int)chr-64;
            sum = sum + (int) Math.pow(26,columnTitle.length()-1 -i ) * num ;
        }
        return sum;
    }


    public static void main(String[] args) {

        System.out.println( convertToTitle(701));

        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }
}
