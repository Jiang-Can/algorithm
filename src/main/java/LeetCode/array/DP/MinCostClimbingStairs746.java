package LeetCode.array.DP;

public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n <= 1) {
            return 0;
        }
        int[] dp = new int[n+1];
        for(int i = 2; i<=n;i++) {
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[n];
    }
}
