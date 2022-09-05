package LeetCode.array;

public class RemoveDuplicatesInSortedArray26 {

    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[len++]=nums[i];
            }
        }
        return len;
    }
}
