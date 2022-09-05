package LeetCode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public int[] bestSolution(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int compliment=0;
        for(int i=0;i<nums.length;i++){
            compliment=target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two solution");
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, String> map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            map.put(nums[i],map.get(nums[i])==null?(""+i):(map.get(nums[i])+""+i));
        }
        Arrays.sort(nums);
        int start=0;
        int end=nums.length-1;
        int sum;
        while (start<end){
            sum=nums[start]+nums[end];
            if(target==sum){
                break;
            }else if(target>sum){
                start++;
            }else {
                end--;
            }
        }
        int i1,i2;
        if(nums[start]==nums[end]){
            String n=map.get(nums[start]);
            i1=Character.getNumericValue(n.charAt(0));
            i2=Character.getNumericValue(n.charAt(1));
        }else {
            i1=Character.getNumericValue(map.get(nums[start]).charAt(0));
            i2=Character.getNumericValue(map.get(nums[end]).charAt(0));
        }
        return new int[]{i1,i2};
    }
}
