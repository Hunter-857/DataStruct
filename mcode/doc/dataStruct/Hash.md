# 哈希

## HASH函数
最简单的哈希函数，异或

安全的HASH算法SHA

散列冲突 解决的方法通常是有 

1.寻址法 -->开放寻址,二次探测,双重散列.

2.链表法.

1. 假设我们有 10 万条 URL 访问日志，如何按照访问次数给 URL 排序？

遍历 10 万条数据，以 URL 为 key，访问次数为 value，存入散列表，同时记录下访问次数的最大值 K，时间复杂度 O(N)。

如果 K 不是很大，可以使用桶排序，时间复杂度 O(N)。如果 K 非常大（比如大于 10 万），就使用快速排序，复杂度 O(NlogN)。

有两个字符串数组，每个数组大约有 10 万条字符串，如何快速找出两个数组中相同的字符串？
以第一个字符串数组构建散列表，key 为字符串，value 为出现次数。再遍历第二个字符串数组，以字符串为 key 在散列表中查找，如果 value 大于零，说明存在相同字符串。时间复杂度 O(N)。


https://mp.weixin.qq.com/s/EYZuflWeSO1RSpKxoG-3ng

hashCode方法的作用
生成haseCode作为对象唯一标识。

NIO是什么？适用于何种场景
NIO模型，select/epoll的区别，多路复用的原理

final/finally/finalize的区别？
String/StringBuffer/StringBuilder的区别，扩展再问他们的实现？

如何用Java分配一段连续的1G的内存空间？需要注意些什么？

ByteBuffer.allocateDirect(1024*1024*1024);

## 什么是java序列化，如何实现java序列化?(写一个实例)？

1.无论何种类型的数据，都是以二进制的形式在网络上传送，为了由一个进程把Java对象发送给另一个进程，需要把其转换为字节序列才能在网络上传送，把JAVA对象转换为字节序列的过程就称为对象的序列化，
将字节序列恢复成Java对象的过程称为对象的反序列化，（然后java.io.ObjectOutPutStream的writeObject(Object obj)的方法就可以 将参数指定
的对象进行序列化 并且把得到的字节流写到一个目标输出流上去）

2.只有实现了 serializable和Externalizable接口的类的对象才能被序列化后者是前者的子类 实现这个借口的类完全由自身来控制序列化的行为，
而仅仅实现前者的类可以采用默认的序列化方式。实现这两个接口 标志着对象可以被序列化了。


## HashMap实现原理

## 分布式缓存，一致性hash
https://mp.weixin.qq.com/s/oe3EPu5DxB0bWheBImMsHg?spm=a2c4e.10696291.0.0.feef19a4t1Q2Ft
