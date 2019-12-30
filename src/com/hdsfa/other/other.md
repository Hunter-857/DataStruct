##java中有哪些创建对象的方法？
 * 通过new关键字
 
        Cat cat = new Cat()
 * 通过反射的方式创建对象
        
          Class c = Cat.class
          Cat cat = (Cat)c.newInstants()
          Constructor constructor = Cat.class.getConstructor();
          Cat cat2 = (Cat) constructor.newInstance();
 * 通过Clone
 
        //Method 3 Clone able
         Cat cat3 = (Cat) cat.clone();
         System.out.println(cat3);
 
 * 通过序列化
  
       //Method 4  将一个对象序列化输出
         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
         out.writeObject(cat3);
         out.close();
       // Method 4   使用反序列化 读入并构造
         System.out.println("===========使用反序列化================");
         ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
         Cat cat5 = (Cat) in.readObject();
         System.out.println(cat5);