package LeetCode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindtheDuplicateNumber287 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num))return num;
            set.add(num);
        }
        return -1;
    }

    public int findDuplicateTortoiseAndRabbit(int[] nums) {
        if(nums.length<=1)
            return -1;
        int slow=nums[0];
        int fast=nums[1];
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        slow=nums[0];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
