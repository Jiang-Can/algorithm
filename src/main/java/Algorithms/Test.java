package Algorithms;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Test {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<3)return res;
        Arrays.sort(nums);
        int i = 0,j,n=nums.length,k=n-1,sum;
        while (i<n-2){
            while (i<n-2&&i!=0&&nums[i]==nums[i-1]){
                i++;
            }
            j = i+1;
            while (j<k){
                sum = nums[i]+nums[k]+nums[j];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else {
                    res.add(List.of(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while (j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                    while (j<k&&nums[k] == nums[k+1]){
                        k--;
                    }
                }
            }
            i++;
            k=n-1;
        }
        return res;
    }

    public void sortColors(int[] nums) {
        int i0 = 0, i2 = nums.length-1,i = 0;
        while (i<=i2){
            if(nums[i] == 0){
                nums[i] = nums[i0];
                nums[i0++] = 0;
            }else if(nums[i] ==2){
                nums[i] = nums[i2];
                nums[i2--] = 2;
                i--;
            }
            i++;
        }
    }




    int top = 0;
    public int test(String s, int k){
        int count = 0;
        for(int i = 0;i<s.length()-1;i++){
            count+= find(i,i,s,k);
            count+= find(i,i+1,s,k);
        }
        return count;
    }

    private int find(int l,int r,String s,int k){
        while (l>top&&r<s.length()){
            if(s.charAt(l)!=s.charAt(r)){
                break;
            }
            if(r-l>=k-1){
                top = r;
                return 1;
            }
            l--;
            r++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Test().test(new int[]{1,2,3,4,5,6}));
    }

    public int test(int[] nums){


        Arrays.sort(nums);
        int n = nums.length;
        int multiple = (int)Math.ceil(n/2.0);

        if(n%2 == 0){
            return getSum(n/2 - 1,n/2,multiple,nums,0);
        }
        return getSum(n/2-1,n/2+1,multiple-1,nums,nums[n/2]*multiple);
    }


    private int getSum(int start, int end, int multiple, int[] nums, int sum){
        while (start>=0&&end<nums.length){
            sum+= (nums[start]+nums[end])*multiple;
            multiple--;
            start--;
            end++;
        }
        return sum;
    }


    public int test1(String s){
        //value[0] = count, value[1] = index;
        Map<Character,int[]> map = new LinkedHashMap<>();
        Character key;
        int[] value;
        for(int i = 0;i<s.length();i++){
            key = s.charAt(i);
            if(map.containsKey(key)){
                value = map.get(key);
                value[0]++;
                map.put(s.charAt(i),value);
            }else {
                map.put(key,new int[]{1,i});
            }
        }
        for(Map.Entry<Character,int[]> entry:map.entrySet()){
            if(entry.getValue()[0] == 1){
                return entry.getValue()[1]+1;
            }
        }
        return -1;
    }

    public int test2(List<Integer> arr){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(Integer num:arr){
            min = Math.min(min,num);
            max = Math.max(max,num-min);
        }
        return max == 0? -1:max;
    }

}

