package LeetCode.array.DP;

public class CountingBits338 {

    //dp solution
    public int[] countBits(int num) {
        int[] dp=new int[num+1];
        for(int i=1;i<=num;i++){
            dp[i]=dp[i>>1]+(i&1);
        }
        return dp;
    }
}
