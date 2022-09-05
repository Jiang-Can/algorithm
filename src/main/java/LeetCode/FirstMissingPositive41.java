package LeetCode;


import java.util.Arrays;

public class FirstMissingPositive41 {

    public static void main(String[] args) {
        FirstMissingPositive41 f = new FirstMissingPositive41();
        System.out.println(f.firstMissingPositive(new int[]{3,4,-1,1}));
    }
    public int firstMissingPositive(int[] nums){
        int i = 0;
        while (i<nums.length){
            if(nums[i]<=nums.length&&nums[i]>=0){
                if(nums[nums[i]-1] == nums[i]){
                    i++;
                }else {
                    swap(nums,nums[i]-1,i);
                }
            }else {
                i++;
            }
        }
        for(i =0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return i+1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
