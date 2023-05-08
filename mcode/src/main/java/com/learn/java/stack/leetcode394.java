package com.learn.java.stack;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

public class leetcode394 {

    static public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charactr = s.charAt(i);
            if(charactr > '0' && charactr <'9'){
                stack.push(charactr);
            }
            if(charactr =='['){

                int j = i+1;
                String tmp = "";
                while (j < s.length() && s.charAt(j)!=']'){
                    if(s.charAt(j) == '['){
                        tmp = "";
                    }else {
                        tmp += String.valueOf(s.charAt(j));
                    }

                    j++;

                }
                stringStack.push(tmp);
            }
        }
        while (!stack.isEmpty() && !stringStack.isEmpty()){
            int length =  stack.pop() - '0';
            StringBuilder builder = new StringBuilder(stringStack.pop());
            String curr = builder.reverse().toString();
            for (int j = 0; j < length; j++) {
                stringBuilder.append(curr);
            }
        }
        System.out.println("stringbulider1 :" +  stringBuilder.reverse());


        return stringBuilder.toString();
    }

    public String decodeString3(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }

    /**
     *  leetcode150
     *
     *  逆波兰表达式主要有以下两个优点：
     *      去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
     *      适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
     *
     * @param tokens
     * @return
     */
    public  static  int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("*");
        arrayList.add("+");
        arrayList.add("-");
        arrayList.add("/");
        if(tokens.length==1) return Integer.parseInt(tokens[0]);
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (!arrayList.contains(tokens[i])) {
                stack.push(tokens[i]);
            }else {

                String popEle1 = stack.pop();
                String popEle2 = stack.pop();

                if(tokens[i].equals("+")){
                    result = Integer.parseInt(popEle1) + Integer.parseInt(popEle2);
                } else if (tokens[i].equals("-")) {
                    result = Integer.parseInt(popEle2) - Integer.parseInt(popEle1) ;
                } else if (tokens[i].equals("*")) {
                    result = Integer.parseInt(popEle1) * Integer.parseInt(popEle2);
                } else if (tokens[i].equals("/")) {
                    result = Integer.parseInt(popEle2) /Integer.parseInt(popEle1) ;
                }
                stack.push(String.valueOf(result));
            }

        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(decodeString("3[a2[c]]]"));

        String[] token = new String[]{"2","1","+","3","*"};
        String[] token1 = new String[]{"4","13","5","/","+"};
        String[] token2 = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result = evalRPN(token2);
        System.out.println(result);
    }
}
