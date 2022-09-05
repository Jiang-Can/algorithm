package LeetCode.array.DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] i = {1, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence300 l=new LongestIncreasingSubsequence300();
        int j=Arrays.binarySearch(i,0,1,8);
        System.out.println(-(j+1));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] dp=new int[nums.length];
        int i,len=0;
        for(int num:nums){
            i=Arrays.binarySearch(dp,0,len,num);
            if(i<0){
                i=-(i+1);
            }
            dp[i]=num;
            if(i==len){
                len++;
            }
        }
        return len;
    }
}
