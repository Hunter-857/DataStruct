# 排序 
常见的排序有很多.

## 冒泡排序

```java

public void bubbleSort(int[] nums){

    for(int i = 0 ; i < nums.length;i++){
         for(int j = 1 ; i < nums.length;j++){
             if(num[i] > num[j]){
                int tmp = num[i];
                int num[i] = num[j];
                int num[j] = num[i];
             }

         }
    }
    }

}

```
## 选择排序

```java

    static public void selectSort(int[] nums){

        for(int i = 0 ; i < nums.length;i++){
            int min = nums[i];
            int minIndex = i;
            int j = i+1;
            for( ; j < nums.length - 1 ;j++){
                if(nums[j] < min){
                    min = nums[j];
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = min;
            nums[minIndex] = tmp;
        }
    }

```
## 插入排序

## 归并排序
## 快速选择
## 希尔排序
## 堆排序
## 筒排序
## 基数排序


数组的前缀和
## 广度优先搜索

广度优先

二维数组

二叉树
> tip : 可以先把遍历写出来 在根据题目要去来写条件和 统计次数的逻辑

## 深度优先搜索

深度优先

二维数组

[leet code200 岛屿问题](https://leetcode-cn.com/problems/number-of-islands/) 
和那个迷宫问题是一样


## 字符串匹配算法
### BF匹配
### BM匹配算法
### KMP匹配算法


## DFA
leetcode 8
DFA，全称 Deterministic Finite Automaton 即确定有穷自动机：
    从一个状态通过一系列的事件转换到另一个状态，即 state -> event -> state。
https://blog.csdn.net/weixin_43378396/article/details/105910145
