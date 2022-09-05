package LeetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindNumbersDisappeared448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index;
        for(int i=0;i<nums.length;i++){
            index=Math.abs(nums[i]);
            if(nums[index-1]>0){
                nums[index-1]*=-1;
            }
        }
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}
