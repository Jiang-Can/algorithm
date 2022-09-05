package LeetCode.array.DP;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        //(sum&1)<==> sum%2
        return (sum &1) == 0 && canFindSum(nums,sum>>1);
    }
    private boolean canFindSum(int[] nums,int sum){
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for(int num:nums){
            for(int i=sum;i>=num;i--){
                dp[i]=dp[i]||dp[i-num];
            }
            if(dp[sum])break;
        }
        return dp[sum];
    }
}
