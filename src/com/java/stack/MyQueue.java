package stack;

import java.util.Stack;

public class MyQueue {
    /**
     * leetcode 232
     */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 =  new Stack();
        this.stack2 =  new Stack();
    }

    public void push(int x) {
        if(stack1.isEmpty()){
            stack2.push(x);
            return;
        }

        while (!stack2.isEmpty()){
            stack1.push(this.stack2.pop());
        }
        stack1.push(x);
        while (!stack1.isEmpty()){
            stack2.push(this.stack1.pop());
        }

    }

    public int pop() {
       return this.stack2.pop();
    }

    public int peek() {
        return this.stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }



}
