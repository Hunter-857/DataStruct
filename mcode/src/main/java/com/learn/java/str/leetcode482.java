package com.learn.java.str;


public class leetcode482 {

    public  static String licenseKeyFormatting(String str, int part) {

        String hanlder = str.replaceAll("-","");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hanlder.length(); i++) {
            stringBuilder.append(hanlder.substring(i,i+1).toUpperCase());
            if( (i+1) % part==0  && (i+1) !=hanlder.length()){
                stringBuilder.append("-");
            }

        }
        //
       //StringBuilder stringBuilder1 = new StringBuilder();
       //Stack<String> stack = new Stack();
       //for (int i = hanlder.length(); i > 0 ; i--) {
       //   stack.push(hanlder.substring(i-1,i).toUpperCase());
       //   stringBuilder1.append(hanlder.substring(i-1,i).toUpperCase());
       //    if( i % part ==1 && i !=1){
       //        stringBuilder1.append("-");
       //        stack.push("-");
       //    }

       //    //5F3Z-2E9W
       //    //4 % 4 =1
       //    // W9E2 Z3F5
       //}

       // stack.stream().forEach(s -> System.out.println(s));
        return stringBuilder.toString();
    }

    public static String licenseKeyFormatting2(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        // 删除末尾的 "-"
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w",4));
        System.out.println(licenseKeyFormatting("2-5g-3-J",2));
        System.out.println(licenseKeyFormatting2("2-5g-3-J",2));
        //StringBuilder builder = new StringBuilder("W9E2-Z3F5");
        //System.out.println( builder.reverse().toString());
    }
}
