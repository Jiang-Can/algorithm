package LeetCode.array;

public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        int max=nums[0],left=0,right=0,n=nums.length;
        for(int i=0;i<n;i++){
            left=(left==0?nums[i]:left*nums[i]);
            right=(right==0?nums[n-1-i]:right*nums[n-1-i]);
            max=Math.max(max,Math.max(left,right));
        }
        return max;
    }
}
