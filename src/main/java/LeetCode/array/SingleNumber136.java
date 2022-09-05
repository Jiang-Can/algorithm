package LeetCode.array;

import java.util.Arrays;

public class SingleNumber136 {
    public int bestSolution(int[] nums){
        int sum=0;
        for(int i:nums){
            sum=sum^i;
        }
        return sum;
    }
    public int singleNumber(int[] nums) {
        int len=nums.length;
        if(len==1)return nums[0];
        Arrays.sort(nums);
        for(int i=0;i<len-1;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[len-1];
    }

}
