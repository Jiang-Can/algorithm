package LeetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3) return res;
        Arrays.sort(nums);
        if(nums[0]>0)return res;
        int i = 0,j=i+1, k = nums.length-1;
        while (i<k){
            
        }
        return null;
    }
}
