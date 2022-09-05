package LeetCode.array;

import java.util.Arrays;

public class PerfectSquares279 {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares279().numSquares(12));
    }
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,n);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }


    public int ns(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        for(int i = 1,num = i*i; num<=n; i++, num = i*i) {
            for(int j = num; j<=n; j++) {
                dp[j] = Math.min(dp[j-num] + 1, dp[j]);
            }
        }
        return dp[n];
    }
}
