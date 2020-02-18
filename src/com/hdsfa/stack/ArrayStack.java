package com.hdsfa.stack;

public class ArrayStack{

    private static  final  int DEFAULT_SIZE = 20;
    private  Object[] data;
    private  int size;
    private  int num;

    public ArrayStack(){
        this.num  = 0;
        this.size = DEFAULT_SIZE;
        this.data =  new Object[size];
    }


    public void add(Object obj){
        if(num == 0)
            data[0] = obj;
        else if(num < size){
            for (int i = data.length; i < 0; i--) {
                data[ i+1 ] = data[i];
            }
            data[0] = obj;
        }else {
            //扩容
        }
        num++;
    }

    public void pop(){
        for (int i = 1; i < size ; i++) {
            data[i-1] = data[i];
        }
    }

    public Object peek(){
        return  this.data[size-1];
    }
}
