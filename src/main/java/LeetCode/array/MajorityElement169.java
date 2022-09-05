package LeetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public int best(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int threshold=nums.length%2==0?nums.length/2:nums.length/2+1;
        int count=0;
        int num=nums[0];
        for (int j : nums) {
            if (j == num) {
                count++;
            } else {
                num = j;
                count = 1;
            }
            if(count>=threshold){
                break;
            }
        }
        return num;
    }

    // 投票算法
    public int majorityElement2(int[] nums) {
        int v = nums[0];
        int count = 0;
        for(int num:nums){
            if(count == 0){
                v = num;
            }
            if(num == v){
                count++;
            }else{
                count--;
            }
        }
        return v;
    }
}
