package LeetCode.array;

import java.util.Queue;

public class ProductofArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int count=0;
        int indexZero=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                indexZero=i;
                count++;
                if(count>1)return new int[nums.length];
            }else{
                product=product*nums[i];
            }
        }
        if(indexZero!=-1){
            int[] res=new int[nums.length];
            res[indexZero]=product;
            return res;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=product/nums[i];
        }
        return nums;
    }
}
