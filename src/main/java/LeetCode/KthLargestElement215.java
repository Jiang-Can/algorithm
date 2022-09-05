package LeetCode;

public class KthLargestElement215 {

    public static void main(String[] args) {
        KthLargestElement215 k = new KthLargestElement215();
        System.out.println(k.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0,nums.length-1,nums,nums.length-k);
    }

    private int quickSelect(int left,int right,int[] nums,int position){
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l<r){
            while (l<r&&nums[r]>=pivot){
                r--;
            }
            while (l<r&&nums[l]<=pivot){
                l++;
            }
            if(l<r){
                swap(l,r,nums);
            }
        }
        swap(left,l,nums);
        if (l == position){
            return pivot;
        }
        if(l<position){
            return quickSelect(l+1,right,nums,position);
        }else {
            return quickSelect(left,l-1,nums,position);
        }
    }

    private static void swap(int i1,int i2,int[] nums){
        int temp;
        temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
