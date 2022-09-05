package LeetCode.array.DP;

import java.util.*;

public class TargetSum494 {
    //dp with math
    public int findTargetSumWays3(int[] nums, int S){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return sum>=S&&(sum+S)%2==0?subsetSum(nums,(S+sum)/2):0;
    }
    private int subsetSum(int[] nums,int sum){
        int[] dp=new int[sum+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=sum;i>=num;i--){
                dp[i]+=dp[i-num];
            }
        }
        return dp[sum];
    }


    public int findTargetSumWaysMemo(int[] nums, int S){
        int[][] memo=new int[nums.length][2001];
        for(int[] m:memo){
            Arrays.fill(m,Integer.MIN_VALUE);
        }
        return dpSol(0,nums,nums.length-1,S,memo);
    }
    private int dpSol(int sum,int[] nums,int i,int target,int[][] memo){
        if(i<0&&sum==target) return 1;
        if(i<0) return 0;
        if(memo[i][sum+1000]!=Integer.MIN_VALUE)return memo[i][sum+1000];
        int positive=dpSol(sum+nums[i],nums,i-1,target,memo);
        int negative=dpSol(sum-nums[i],nums,i-1,target,memo);
        memo[i][sum+1000]=positive+negative;
        return negative+positive;
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int n=nums.length;
        int[] binArr=new int[(int)Math.pow(2, n)-1];
        binArr[0]=0;
        int end,j=1,parent;
        for(int i=1;i<n;i++){
            end=j+(int)Math.pow(2, i);
            while (j<end){
                parent=binArr[(j-1)/2];
                binArr[j++]=parent-nums[i-1];
                binArr[j++]=parent+nums[i-1];
            }
        }
        int count=0;
        end=j+(int)Math.pow(2,n);
        while (j<end){
            parent=binArr[(j-1)/2];
            if(parent-nums[n-1]==S)count++;
            if(parent+nums[n-1]==S)count++;
            j+=2;
        }
        return count;
    }

    //all number in nums are equal to 1
    public int findTargetSumWays(int[] nums, int S) {
        int N=nums.length;
        if(N%2!=S%2||N<S)return 0;
        int M=(N-S)/2;
        double res=1.0;
        for(int i=M;i>=1;i--){
            res*=(N-i+1);
            res/=i;
        }
        int c=(int)res;
        return res-c<c+1-res?c:c+1;
    }
}
