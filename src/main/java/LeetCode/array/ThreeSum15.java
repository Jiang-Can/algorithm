package LeetCode.array;

import java.util.*;

public class ThreeSum15 {
    //good solution
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists=new LinkedList<>();
        Arrays.sort(nums);
        int len=nums.length;
        if(len<3||nums[0]>0){
            return lists;
        }
        for(int i=0;i<len-2;i++){
            //找不同的起始点
            if(i == 0 || nums[i] != nums[i - 1]){
                int low=i+1;
                int high=len-1;
                while (low<high){
                    if(nums[i]+nums[low]+nums[high]==0){
                        lists.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while (low<high&&nums[low]==nums[low+1])low++;
                        while (low<high&&nums[high]==nums[high-1])high--;
                        low++;
                        high--;
                    }else if(nums[i]+nums[low]+nums[high]<0){
                        low++;
                    }else { //>0 need to decrease the sum
                        high--;
                    }
                }
            }
        }
        return lists;
    }

    //low efficiency solution
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new LinkedList<>();
        Arrays.sort(nums);
        int len=nums.length;
        if(len<3)return lists;
        int i=0;
        int j=1;
        int k=2;
        while (i<=len-3){
            List<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(nums[k]);
            if(checkSum(list)){
                lists.add(list);
            }

            if (j < len - 2) {
                if (k < len- 1 ){
                    k++;
                }else{
                    j++;
                    k=j+1;
                }
            } else {
                i++;
                j = i + 1;
                k = j + 1;
            }
        }
        return trimDuplicate(lists);
    }
    private boolean checkSum(List<Integer> list){
        int sum=0;
        for(Integer i:list){
            sum+=i;
        }
        return sum==0;
    }
    private List<List<Integer>> trimDuplicate(List<List<Integer>> lists){
        Set<Integer> remove=new HashSet<>();
        int i=0;
        while (i<lists.size()){
            int j=i+1;
            while (j<lists.size()){
                int flag=0;
                for(int k=0;k<3;k++){
                    if(lists.get(i).get(k).equals(lists.get(j).get(k))){
                        flag++;
                    }
                }
                if(flag==3){
                    lists.remove(j);
                }else{
                    j++;
                }
            }
            i++;
        }
        return lists;
    }
}
