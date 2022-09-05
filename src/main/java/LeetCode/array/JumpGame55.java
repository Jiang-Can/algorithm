package LeetCode.array;

import java.util.Arrays;

public class JumpGame55 {
    //Greedy solution
    public boolean canJumpGreedy(int[] nums) {
        int lastPst=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=lastPst){
                lastPst=i;
            }
        }
        return lastPst==0;
    }





    //DP solution
    enum Index{
        GOOD,BAD
    }
    public boolean canJump(int[] nums) {
        Index[] memo=new Index[nums.length];
        Arrays.fill(memo, Index.GOOD);
        return findJump(nums,0,memo);
    }
    private boolean findJump(int[] nums,int i,Index[] memo){
        if(i>=nums.length||memo[i]==Index.BAD)return false;
        if(i+nums[i]>=nums.length-1)return true;
        for(int j=nums[i];j>0;j--){
            if(findJump(nums,i+j,memo)){
                return true;
            }
        }
        memo[i]=Index.BAD;
        return false;
    }
}
