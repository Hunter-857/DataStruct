## 图的概念
   顶点 边 连通 连通分量
## 表示方式
实现方式：
* 邻接矩阵
* 邻接表数组

## 搜索
### 迷宫问题来解释
* 深度预先搜索  一个人走迷宫

```
    /*
     * Return true if there is a path from cur to target.
     */
    boolean DFS(int root, int target) {
        Set<Node> visited;
        Stack<Node> s;
        add root to s;
        while (s is not empty) {
            Node cur = the top element in s;
            return true if cur is target;
            for (Node next : the neighbors of cur) {
                if (next is not in visited) {
                    add next to s;
                    add next to visited;
                }
            }
            remove cur from s;
        }
        return false;
    }

```
* 广度优先搜索  一组人走迷宫