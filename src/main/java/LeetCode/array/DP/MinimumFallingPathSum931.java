package LeetCode.array.DP;

public class MinimumFallingPathSum931 {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxValue = 10001;
        int[][] dp = new int[m+1][n+2];
        int min = maxValue;
        for(int i = 1; i<m; i++) {
            dp[i][0] = maxValue;
            dp[i][n+1] = maxValue;
        }
        for(int i = 1; i<=m;i++) {
            for(int j = 1; j<=n; j++) {
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1]) + matrix[i-1][j-1];
                if(i == m) {
                    min = Math.min(dp[i][j],min);
                }
            }
        }
        return min;
    }
}
