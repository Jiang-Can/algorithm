package LeetCode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        FourSum f = new FourSum();
        f.recurFSum(new int[]{1,0,-1,0,-2,2,0},0);
    }

    int target;
    public List<List<Integer>> recurFSum(int[] nums, int target){
        //len means the number of sum
        int len = 4;
        Arrays.sort(nums);
        return findComp(nums,target,len,0);
    }
    public List<List<Integer>> findComp(int[] nums,int target, int len, int index){

        List<List<Integer>> res = new LinkedList<>();
        if(index >= nums.length){
            return res;
        }
        if(len == 2){
            int i = index, j = nums.length-1;
            while (i<j){
                if(nums[i]+nums[j]>target){
                    j--;
                }else if(nums[i]+nums[j]<target){
                    i++;
                }else{
                    res.add(new LinkedList<>(Arrays.asList(nums[i],nums[j])));
                    while (i<j&&nums[i] == nums[i+1]){
                        i++;
                    }
                    while (i<j&&nums[j] == nums[j-1]){
                        j--;
                    }
                    i++;
                    j--;
                }
            }
        }else {
            for(int i = index;i<nums.length-len+1;i++){
                List<List<Integer>> temp = findComp(nums,target-nums[i],len-1,i+1);
                if(temp.size()>0){
                    for(List<Integer> list:temp){
                        list.add(0,nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i<nums.length-len+1&&nums[i+1]==nums[i]){
                    i++;
                }
            }

        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        int i=0,j,k,z=nums.length-1,diff;
        while (i<z-2){
            while (i!=0&&i<z-2&&nums[i-1]==nums[i]){
                i++;
            }
            j = i+1;
            while (j<z-1){
                while (j!=i+1&&j<z-1&&nums[j-1]==nums[j]){
                    j++;
                }
                k = j+1;
                while (k<z){
                    diff = nums[i]+nums[j]+nums[k]+nums[z] - target;
                    if ( diff > 0){
                        z--;
                    }else if(diff<0){
                        k++;
                    }else {
                        res.add(new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[z])));
                        while (k<z&&nums[k]==nums[k+1]){
                            k++;
                        }
                        while (k<z&&nums[z]==nums[z-1]){
                            z--;
                        }
                        k++;
                        z--;
                    }
                }
                j++;
                z = nums.length-1;
            }
            i++;
            z = nums.length-1;
        }
        return res;
    }
}
