package LeetCode.array;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        SearchInRotatedSortedArray33 s=new SearchInRotatedSortedArray33();
        int[] arr={4,5,6,7,0,1,2};
        s.search2(arr, 0);
    }
    public int search2(int[] nums, int target) {
        int len=nums.length;
        int lo=0,hi=len-1;
        int mid;
        while (lo<hi){
            mid=(lo+hi)/2;
            if (nums[mid]>nums[hi]) {
                lo=mid+1;
            }else{
                //这里mid不减1的原因是因为，判断条件为nums[mid]<nums[mid]，此时可能mid正好在数组起始点，如果减1就会错过该点
                hi=mid;
            }
        }
        int rotate=lo;
        int realMid;
        lo=0;hi=len-1;
        while (lo<=hi){
            mid=(lo+hi)/2;
            realMid=(mid+rotate)%len;
            if(target<nums[realMid]){
                hi=mid-1;
            }else if(target>nums[realMid]){
                lo=mid+1;
            }else
                return realMid;
        }
        return -1;

    }
}
