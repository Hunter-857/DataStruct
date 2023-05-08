package com.learn.java.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class leetcode1172 {

    static class DinnerPlates {

        private int capacity;
        private int count;
        private List<List<Integer>> stack;
        private LinkedList<Integer> firstInner;
        public DinnerPlates(int capacity) {
          this.capacity = capacity;
          this.stack = new ArrayList<>();
          this.count = 0;

        }

        public void push(int val) {
            int currentSize = this.stack.size();
            if(this.count < this.capacity){
                if(this.firstInner == null){
                    this.firstInner = new LinkedList<>();
                    this.stack.add(this.firstInner);
                }
                this.firstInner.addFirst(val);
            }else {
                int total = this.capacity * currentSize;
                if (this.count < total) {
                    for (int i = 0; i < currentSize; i++) {
                        LinkedList<Integer> tmp = (LinkedList<Integer>) stack.get(i);
                        if(tmp.size() < this.capacity){
                            tmp.addFirst(val);
                            break;
                        }
                    }
                }else{
                    LinkedList<Integer> tmp = new LinkedList<>();
                    tmp.addFirst(val);
                    this.stack.add(tmp);
                }
            }
            this.count++;
        }

        public int pop() {
            int size = this.stack.size();
            if(size == 0){
                return  -1;
            }
            LinkedList<Integer> lastInner = (LinkedList<Integer>) stack.get(size-1);
            int ans = lastInner.removeFirst();
            if(lastInner.size() == 0){
                this.stack.remove(size-1);
            }

            this.count--;
            return ans;

        }

        public int popAtStack(int index) {
            int last = -1;
            if(index > this.stack.size()){
                return -1;
            }
            LinkedList<Integer> tmp = (LinkedList) this.stack.get(index);
            last = tmp.removeFirst();
            if(tmp.size()==0){
                stack.remove(tmp);
            }
            this.count--;
            return last;
        }
    }

    public static void main(String[] args) {

        DinnerPlates D = new DinnerPlates(2);
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);
        D.popAtStack(0);
        D.push(20);
        D.push(21);
        D.popAtStack(0);
        D.popAtStack(2);
        D.pop() ;
        D.pop()  ;
        D.pop() ;
        D.pop()  ;
        D.pop()  ;

        //DinnerPlates D = new DinnerPlates(1);
        //D.push(1);
        //D.push(2);
        //D.push(3);
        //D.popAtStack(1);
        //D.pop();
        //D.pop();

        //["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
        //[[2],             [1],  [2],   [3],   [4],   [7],   [8],[20],[21],[0],[2],[],[],[],[],[]]
        //
        DinnerPlates D2 = new DinnerPlates(2);
        D2.push(1);
        D2.push(2);
        D2.push(3);
        D2.push(4);
        D2.push(7);
        D2.popAtStack(8);
        D2.push(20);
        D2.push(21);
        D2.popAtStack(0);
        D2.popAtStack(2);
        D2.pop() ;
        D2.pop()  ;
        D2.pop() ;
        D2.pop()  ;
        D2.pop()  ;

        //["DinnerPlates","push","push","popAtStack","pop","push","push","pop","pop"]
        //[      [1],     [1],    [2],   [1],         [],[1],[2],[],[]]
        DinnerPlates D3 = new DinnerPlates(1);
        D3.push(1);
        D3.push(2);
        D3.push(1);
        D3.pop();
        D3.push(1);
        D3.popAtStack(2);
        D3.pop()  ;
        D3.pop()  ;

    }
}
