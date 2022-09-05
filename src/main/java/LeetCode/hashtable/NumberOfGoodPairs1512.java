package LeetCode.hashtable;

import java.util.HashMap;

public class NumberOfGoodPairs1512 {

    int mathSolution(int[] nums){
        int[] countArr=new int[101];
        for(int num:nums){
            countArr[num]++;
        }
        int sum=0;
        for(int count:countArr){
            if(count!=0&&count!=1){
                sum+=count*(count-1)/2;
            }
        }
        return sum;
    }
    int hashMapSolution(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int num:nums){
            if(map.get(num)==null){
                map.put(num, 1);
            }else{
                map.put(num,map.get(num)+1);
            }
            count+=map.get(num)-1;
        }
        return count;
    }

    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j])count++;
            }
        }
        return count;
    }
}
