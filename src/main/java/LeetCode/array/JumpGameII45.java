package LeetCode.array;

import java.util.Arrays;

public class JumpGameII45 {
    //O(n) solution
    public int jump2(int[] nums) {
        if(nums.length==1)return 0;
        int slow=0,fast=0,count=0;
        for(int i=0;i<nums.length-1;i++){
            fast=Math.max(fast,i+nums[i]);
            if(fast>=nums.length-1){
                count++;break;
            }
            if(i==slow){
                count++;
                slow=fast;
            }
        }
        return count;
    }

    public int jump(int[] nums) {
        int pos;
        nums[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]!=0){
                if((pos=i+nums[i])>nums.length-1){
                    pos=nums.length-1;
                }
                nums[i]=nums[pos]+1;
                for(int j=i+1;j<pos;j++){
                    if(nums[i]<nums[j]){
                        nums[j]=nums[i];
                    }else break;
                }
            }else {
                nums[i]=100001;
            }
        }
        return nums[0];
    }
}
