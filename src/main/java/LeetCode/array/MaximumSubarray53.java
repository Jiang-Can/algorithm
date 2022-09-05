package LeetCode.array;

public class MaximumSubarray53 {

    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=sum>0?nums[0]+sum:nums[0];
            max=Math.max(max,sum);
        }
        return max;
    }
}
