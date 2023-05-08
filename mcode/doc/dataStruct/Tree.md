# 树
## 二叉树

二叉树的遍历，前中后序,这里的前中后序是指root的节点前中后。都是从左侧节点开始的。

### 遍历的的代码实现

1. 递归

递归其实是一种深度优先搜素，递归的方式代码容易理解，但是因为算法的速度比叫慢。

```java
    //借助递归的深度优先
    public void  preOrder(TreeNode listNode){
        if(listNode != null) System.out.println(listNode.val);
        if(listNode!=null) preOrder(listNode.left);
        if(listNode!=null) preOrder(listNode.right);
    }

    public void inOrder(TreeNode listNode){
        if(listNode!=null) inOrder(listNode.left);
        if(listNode!=null) System.out.print(listNode.val+ " ");
        if(listNode!=null) inOrder(listNode.right);
    }
    public void afterOrder(TreeNode listNode){
        if(listNode!=null) afterOrder(listNode.left);
        if(listNode!=null) afterOrder(listNode.right);
        if(listNode!=null) System.out.print(listNode.val + " ");
    }

```


2.非递归
  
若是非递归就需要借助栈来实现遍历。

```java

    //借助堆栈来消除, 左边压进去，直到到左边没有了，就弹出来一个，走到右边去
    public static  void  preOrderNoRecursion(TreeNode listNode){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = listNode;
        while(treeNode!=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while(treeNode != null){
                System.out.print(treeNode.val+" ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }

    }

    public static void innerOderNoRecursion(TreeNode listNode){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode treeNode = listNode;
            while(treeNode!=null || !stack.isEmpty()){
                while(treeNode != null){
                    stack.push(treeNode);
                    treeNode = treeNode.left;
                }
                treeNode = stack.pop();
                System.out.print(treeNode.val+" ");
                treeNode = treeNode.right;
    
        }
    }

     public  static  void afterOderNoRecursion(TreeNode listNode){
     Stack<TreeNode> stack = new Stack<TreeNode>();
     TreeNode treeNode = listNode;
     TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点
     //节点不为空，结点入栈，并且指向下一个左孩子
     while(treeNode!=null || !stack.isEmpty()){
         while(treeNode!=null){
             stack.push(treeNode);
             treeNode = treeNode.left;
         }
         //栈不为空
         if(!stack.isEmpty()){
             //出栈
             treeNode = stack.pop();
             /**
              * 这块就是判断treeNode是否有右孩子，
              * 如果没有输出treeNode.data，让lastVisit指向treeNode，并让treeNode为空
              * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
              */
             if(treeNode.right == null || treeNode.right == lastVisit) {
                 System.out.print(treeNode.val + " ");
                 lastVisit = treeNode;
                 treeNode  = null;
             }else{
                 stack.push(treeNode);
                 treeNode = treeNode.right;
             }

         }

     }
    }
```

前顺序和中序实现很像啊--> 如何确定一颗二叉树？



### 遍历的利用 

所有时候题目不会只是打印出来一颗树来，比如提要将结果存入一个list中，那么我就需要吧原来的方法改造一下。

>方式一

在递归的参数中加入集合。那么集合一直在增加。

```java
        // 借助递归的深度优先
        class Solution {
            public List<Integer> preorderTraversal(TreeNode root) {
                 List list = new ArrayList();
                 preOrder(root,list);
                 return list;
            }
             // 深度优先搜索的方式
            public void preOrder(TreeNode listNode, List<Integer> list){
                if(listNode != null)list.add(listNode.val);
                if(listNode!=null) preOrder(listNode.left,list);
                if(listNode!=null) preOrder(listNode.right,list);
            }
        }

```
>方式二

定义了一个属性，那么这个list是全局的。感觉第二种方式简洁一些。

```java
    // 借助递归的深度优先
    class Solution {
        List<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
                preOrder(root);
                return list;
        }
            // 深度优先搜索的方式
        public void preOrder(TreeNode listNode){
            if(listNode != null)list.add(listNode.val);
            if(listNode!=null) preOrder(listNode.left,list);
            if(listNode!=null) preOrder(listNode.right,list);
        }
    }

```
### mirror 遍历

有一种巧妙的方法可以在线性时间内，只占用常数空间来实现后序遍历。
这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」中首次提出，因此被称为 Morris 遍历。
这一中更加高效的遍历方式，利用的是树的叶节点左右孩子为空（树的大量空闲指针），实现空间开销的极限缩减。

* 假设当前节点为cur，并且开始时赋值为根节点root(其实也可以直接对root操作)。
* 循环判断cur不为空
   1. if左子树为空，则cur向右孩子移动
   2. if左子树不为空，找到左子树的最右节点(也就是左子树一直往右走的，走到到尽头就是它的最右节点)
   如果最右节点的右指针为空，则把右指针指向cur，cur向左孩子移动
   如果最右节点的右指针为cur本身，则说明已经访问过一遍了，我们将其置为null，cur向右孩子移动
* cur为空时，退出循环


Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其后序遍历规则总结如下：

1.新建临时节点，令该节点为 root；

2.如果当前节点的左子节点为空，则遍历当前节点的右子节点；

3.如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点；

    如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点，当前节点更新为当前节点的左子节点。

    如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右子节点。

重复步骤 2 和步骤 3，直到遍历结束。

这样我们利用 Morris 遍历的方法，后序遍历该二叉搜索树，即可实现线性时间与常数空间的遍历。

https://zhuanlan.zhihu.com/p/101321696


**按层**来遍历也是广度优先搜素
将每层的点加入队列中，队列先进先出

```java

    public static  List<List<Integer>> readTree(TreeNode root){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 没层new 出一个list来存储val
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode listNode = queue.poll();
                level.add(listNode.val);
                if (listNode.left != null) {
                    queue.offer(listNode.left);
                }
                if (listNode.right != null) {
                    queue.offer(listNode.right);
                }
            }
            ret.add(level);
        }
        return ret;
     }

```


# 树
https://mp.weixin.qq.com/s/EYZuflWeSO1RSpKxoG-3ng
hashCode方法的作用
生成haseCode作为对象唯一标识。

NIO是什么？适用于何种场景
NIO模型，select/epoll的区别，多路复用的原理

final/finally/finalize的区别？
String/StringBuffer/StringBuilder的区别，扩展再问他们的实现？

如何用Java分配一段连续的1G的内存空间？需要注意些什么？
ByteBuffer.allocateDirect(1024*1024*1024);

什么是java序列化，如何实现java序列化?(写一个实例)？
1.无论何种类型的数据，都是以二进制的形式在网络上传送，为了由一个进程把Java对象发送给另一个进程，需要把其转换为字节序列才能在网络上传送，把JAVA对象转换为字节序列的过程就称为对象的序列化，
将字节序列恢复成Java对象的过程称为对象的反序列化，（然后java.io.ObjectOutPutStream的writeObject(Object obj)的方法就可以 将参数指定的对象进行序列化 并且把得到的字节流写到一个目标输出流上去）
2.只有实现了 serializable和Externalizable接口的类的对象才能被序列化后者是前者的子类 实现这个借口的类完全由自身来控制序列化的行为，
而仅仅实现前者的类可以采用默认的序列化方式。实现这两个接口 标志着对象可以被序列化了。

HashMap实现原理

15
## 分布式缓存，一致性hash
https://mp.weixin.qq.com/s/oe3EPu5DxB0bWheBImMsHg?spm=a2c4e.10696291.0.0.feef19a4t1Q2Ft

动态规划核心框架

## AVL 树
左旋, 右旋

## B-Tree B+Tree

### 例题

 [leetcode100](../src/main/java/tree/leetcode100.java)

 [leetcode101](../src/main/java/tree/leetcode101.java)



