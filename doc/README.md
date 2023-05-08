# 算法与数据结构笔记

## 位运算
有时候会出现一些关于编码的问题，所以就先标记在这里。

正数的反码 补码都形同

负数的反码 --> 除了符号位，其他位置取反
负数的补码 --> 取反码之后在末尾加 1

 | Value | 编码  | 反码 | 补码 |
 | ----- | ---- | ---- | ---- |
 |  16    |      |      |
 | -16   |      |      |
 |  32    |      |      |
 | -32   |      |      |

## 常见的位运算

  * 按位与 &  

    1&1 = 1,
    1&0 = 0,
    0&0 = 0,
    0&1 = 0
 
  * 按位或 ｜

  * 按位非 ～

  * 按位异或 ^

    1^1=0 , 1^0=1, 0^0=0
    任何数组和自己异或结果是0
  
  * 有符号右移动 >>
     相当于除以2

  * 有符号左移动 <<

   无符号右移动 >>> (无论正负 高位补0) 


* 取模运算

 ```shell
    a%(2^n) ---equals---> a&(2^n - 1)
```

利用异或交换两个变量
    
```shell
    a = a^b
    b = a^b
    a = a^b
```


> example
  
  [leetcode136 只出现一次的数字 I](../src/com/ag/src/main/java/str/leetcode136.java)

  [leetcode137 只出现一次的数字 II](../src/com/ag/src/main/java/str/leetcode136.java)

  [leetcode260 只出现一次的数字 III](../src/com/ag/src/main/java/str/leetcode136.java)
  
  数组中两个数的最大异或值
  重复的DNA序列
  最大单词长度乘积



[各种排序](algorithm/sort.md)
贪心
[动态规划](algorithm/DP.md)
深度优先搜索
广度优先搜索
二分查找
回溯，递归

滑动窗口

  leetcode3
  我们不妨以示例一中的字符串 \texttt{abcabcbb}abcabcbb 为例，找出从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。对于示例一中的字符串，我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：
    以 \texttt{(a)bcabcbb}(a)bcabcbb 开始的最长字符串为 \texttt{(abc)abcbb}(abc)abcbb；
    以 \texttt{a(b)cabcbb}a(b)cabcbb 开始的最长字符串为 \texttt{a(bca)bcbb}a(bca)bcbb；
    以 \texttt{ab(c)abcbb}ab(c)abcbb 开始的最长字符串为 \texttt{ab(cab)cbb}ab(cab)cbb；
    以 \texttt{abc(a)bcbb}abc(a)bcbb 开始的最长字符串为 \texttt{abc(abc)bb}abc(abc)bb；
    以 \texttt{abca(b)cbb}abca(b)cbb 开始的最长字符串为 \texttt{abca(bc)bb}abca(bc)bb；
    以 \texttt{abcab(c)bb}abcab(c)bb 开始的最长字符串为 \texttt{abcab(cb)b}abcab(cb)b；
    以 \texttt{abcabc(b)b}abcabc(b)b 开始的最长字符串为 \texttt{abcabc(b)b}abcabc(b)b；
    以 \texttt{abcabcb(b)}abcabcb(b) 开始的最长字符串为 \texttt{abcabcb(b)}abcabcb(b)。

leetcode219
  左右指针 i，j 
  j > i

双指针
分治
记忆化搜索
    通过一些hashmap，arraylist 记录讯息

[遗传算法](algorithm/GA.md)
https://www.likecs.com/show-204115703.html


