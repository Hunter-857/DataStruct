HashMap实现原理
  开始时数组加链表
   对象的hashCode 会对应数组的一个元素
   初始容量 DEFAULT_INITIAL_CAPACITY = 1 << 4
   加载因子 DEFAULT_LOAD_FACTOR = 0.75f;
   扩容阈值 threshold  ==>超过就会扩容
   在构造函数中 判断了初始化量的合理性 
   在put 的时候inflatetable()
   hash 散列的位扰动
   头部节点插入法
   
   扩容的过程的循环，有死循环产生的
   
  java7 之后hashMap 是使用红黑树实现  节点中超过8个元素就会改用红黑树
