package LeetCode.array;

import java.util.Arrays;

public class ThreeSumCloset16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0,j,k=nums.length-1;
        int min = Integer.MAX_VALUE;
        int diff;
        int res = 0;
        while (i<k-1){
            j = i+1;
            while (j<k){
                diff = target-(nums[i]+nums[j]+nums[k]);
                if(Math.abs(diff)<min){
                    min = Math.abs(diff);
                    res = nums[i]+nums[j]+nums[k];
                    if(diff == 0){
                        break;
                    }
                }
                if(diff<0){
                    k--;
                }else{
                    j++;
                }
            }
            i++;
            k = nums.length-1;
        }
        return res;
    }
}
