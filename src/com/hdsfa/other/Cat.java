package com.hdsfa.other;

import java.io.*;
import java.lang.reflect.Constructor;

public class Cat implements Cloneable, Serializable {
    private String name;
    private int age;

    public Cat(){
        this.name = "tom";
        this.age = 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        //Method 1
        Cat cat = new Cat();
        System.out.println(cat);
        //Method 2  reflect
        Class clazz = Cat.class;
        try {
            //not Recommend After Java 9
            Cat cat1 = (Cat) clazz.newInstance();
            Constructor constructor = Cat.class.getConstructor();
            Cat cat2 = (Cat) constructor.newInstance();
            System.out.println(cat1);
            System.out.println(cat2);

            //Method 3 Clone able
            Cat cat3 = (Cat) cat.clone();
            System.out.println(cat3);

            //Method 4  将一个对象序列化输出
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
             out.writeObject(cat3);
             out.close();
             // Method 4   使用反序列化 读入并构造
             System.out.println("===========使用反序列化================");
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
             Cat cat5 = (Cat) in.readObject();
             System.out.println(cat5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
