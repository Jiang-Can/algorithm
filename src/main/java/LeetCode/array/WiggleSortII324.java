package LeetCode.array;

import java.util.Arrays;

public class WiggleSortII324 {
    public static void main(String[] args) {
        wiggleSort(new int[]{1,3,2,2,3,1});
    }
    public static void wiggleSort(int[] nums) {
        int find,temp;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<nums[0]){
                temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;
                break;
            }
        }

        int i = 0;
        while (i<nums.length-1) {
            if((nums[i+1]-nums[i])*(i%2==0?1:-1)<=0){
                find = i+2;
                while (find<nums.length){
                    if((nums[find]-nums[i])*(i%2==0?1:-1)>0){
                        temp = nums[i+1];
                        nums[i+1] = nums[find];
                        nums[find] = temp;
                        break;
                    }
                    find++;
                }
                if(find == nums.length){
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            i++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
