package ag;

public class leetcode746 {


    public int minCostClimbingStairs(int[] cost) {
        // f(x) = min( dp(x-1)+cos(i-1) , dp(x-2)+cos(i-2) )
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public int minCostClimbingStairs1(int[] cost){
        int n = cost.length;
        int[] minCost =  new int[n];

        minCost[0]=0;
        minCost[1] = Math.min(cost[0],cost[1]);

        for (int i = 2; i < cost.length; i++) {

            minCost[i] = Math.min(minCost[i-1]+cost[i],minCost[i-2]+cost[i-1]);
            
        }

        return  minCost[n-1];
    }


    public static void main(String[] args) {

    }


}
