package LeetCode.array;

import java.util.Arrays;
import java.util.HashMap;

public class SubarraySumEqualsK560 {


    //hashmap solution
    public int subarraySum3(int[] nums, int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,res=0;
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);//加入map要放在判断后面,这样可以解决k=0的情况例如 k=0,nums=[1]
        }
        return res;
    }


    public int subarraySum(int[] nums, int k){
        int sum,res=0;
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k)res++;
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k){
        int[] sums=new int[nums.length+1];
        int res=0;
        for(int i=1;i<sums.length;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        for(int i=0;i<sums.length-1;i++){
            for(int j=i+1;j<sums.length;j++){
                if(sums[j]-sums[i]==k)res++;
            }
        }
        return res;
    }



    // In the case that array is ordered
    public int subarraySumNotInQuestion(int[] nums, int k) {
        Arrays.sort(nums);
        int explore=0,n=nums.length;
        int i=0,sum=0,res=0;
        while (explore<n){
            while (explore<n&&sum<k){
                sum+=nums[explore++];
            }
            if(sum>k){
                if(i==explore)break;
                sum-=nums[i++];
            }
            if(sum==k){
                res++;
                if(i==explore){
                    i++;
                    while (i<n&&nums[i]==k){
                        res++;i++;
                    }
                    break;
                }
                sum-=nums[i++];
            }
        }
        return res;
    }
}
