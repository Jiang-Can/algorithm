package LeetCode.array;

public class FindFirstLastPositionElementSortedArray34 {
    //ordered arr
    public int[] searchRange2(int[] nums, int target) {
        int i=findPosition(nums, target, 0,nums.length-1);
        int start=i;
        if(i!=-1){
            while (i<nums.length-1&&nums[i]==nums[i+1])i++;
            while (start>=1&&nums[start]==nums[start-1])start--;
        }
        return new int[]{start,i};
    }
    private int findPosition(int[] nums, int target,int start,int end){
        if(start>end)return -1;
        int mid=(start+end)/2;
        if(nums[mid]==target){
            return mid;
        }else if(target<nums[mid]){
            return findPosition(nums, target, start, mid-1);
        }else {
            return findPosition(nums, target, mid+1,end);
        }
    }

    //case that arr has not been ordered
    public int[] searchRange(int[] nums, int target) {
        int start=-1,end=-1;
        int i=0,j=nums.length-1,temp;
        while (i<j){
            while (i<j&&nums[i]<target)i++;
            while (i<j&&nums[i]>=target)j--;
            if(i<j){
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        if(i<nums.length&&nums[i]==target){
            start=i;
            while (i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
            end=i;
        }
        return new int[]{start,end};
    }
}
