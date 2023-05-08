package ag;

import java.util.*;

public class leetcode22 {




   static List<List<Integer>> ans = new ArrayList<>();

    /**
     *   回溯算法与深度优先遍历
     *  以下是维基百科中「回溯算法」和「深度优先遍历」的定义。
     *
     *   回溯法:
     *   采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，
     *   它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
     *    回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
     *    找到一个可能存在的正确的答案；
     *    在尝试了所有可能的分步方法后宣告该问题没有答案。
     *
     * 深度优先搜索 算法（英语：Depth-First-Search，DFS）是一种用于遍历或搜索树或图的算法。
     * 这个算法会 尽可能深 的搜索树的分支。
     * 当结点 v 的所在边都己被探寻过，搜索将 回溯 到发现结点 v 的那条边的起始结点。
     * 这一过程一直进行到已发现从源结点可达的所有结点为止。
     * 如果还存在未被发现的结点，则选择其中一个作为源结点并重复以上过程，整个进程反复进行直到所有结点都被访问为止。
     *
     * 我刚开始学习「回溯算法」的时候觉得很抽象，一直不能理解为什么递归之后需要做和递归之前相同的逆向操作，
     * 在做了很多相关的问题以后，我发现其实「回溯算法」与「 深度优先遍历 」有着千丝万缕的联系。
     *
     * @param nums
     * @return
     */
   static public List<List<Integer>> permute2(int[] nums) {
       int len = nums.length;
       // 使用一个动态数组保存所有可能的全排列
       List<List<Integer>> res = new ArrayList<>();
       if (len == 0) {
           return res;
       }
       boolean[] used = new boolean[len];
       List<Integer> path = new ArrayList<>();
       dfs(nums, len, 0, path, used, res);
        return ans;
   }
   static  private void dfs(int[] nums, int len, int depth,
                               List<Integer> path, boolean[] used,
                               List<List<Integer>> res) {
       if (depth == len) {
           res.add(path);
           return;
       }
       // 在非叶子结点处，产生不同的分支，
       // 这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
       for (int i = 0; i < len; i++) {
           if (!used[i]) {
               path.add(nums[i]);
               used[i] = true;

               dfs(nums, len, depth + 1, path, used, res);
               // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
               used[i] = false;
               path.remove(path.size() - 1);
           }
       }
   }

    /**
     *  leetcode 22  回溯的方法
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    static ArrayList[] cache = new ArrayList[100];

    static public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList <String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    static public List<String> generateParenthesis2(int n) {
        return generate(n);
    }


    /**
     *  使用 堆栈来消除递归
     * @param n
     * @return
     */
     public List<String> generateParenthesis4(int n) {
        List<String> ans = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        stack.push(new State(new StringBuilder(), 0, 0));
        while (!stack.isEmpty()) {
            State cur = stack.pop();
            if (cur.sb.length() == n * 2) {
                ans.add(cur.sb.toString());
                continue;
            }
            if (cur.open < n) {
                State next = new State(
                        new StringBuilder(cur.sb).append("("),
                        cur.open + 1,
                        cur.close
                );
                stack.push(next);
            }
            if (cur.close < cur.open) {
                State next = new State(
                        new StringBuilder(cur.sb).append(")"),
                        cur.open,
                        cur.close + 1
                );
                stack.push(next);
            }
        }
        return ans;
    }

     class State {
        StringBuilder sb;
        int open;
        int close;

        public State(StringBuilder sb, int open, int close) {
            this.sb = sb;
            this.open = open;
            this.close = close;
        }
    }

    public static void main(String[] args) {
        // 回溯的方法
        System.out.println(generateParenthesis(3));
        //深度遍历
        //System.out.println(generateParenthesis2(3));
        leetcode22 soulation = new leetcode22();
        System.out.println(soulation.generateParenthesis4(3));


   }

}
