package LeetCode.array;

public class RotateArray189 {
    //运用加法群的陪集(coset)不重叠的性质
    public void rotate3(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        int start,end,last,cur;
        int count=0;
        //这里使用count记录步数
        for(int i=0;count<len;i++){
            start=i;
            end=i;
            last=nums[i];
            do{
                start=(start+k)%len;
                cur=nums[start];
                nums[start]=last;
                last=cur;
                count++;
            }while (start!=end);
        }
    }


    //reverse solution
    public void rotate2(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        reverse(nums, 0,len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    private void reverse(int[] nums,int start,int end){
        int temp;
        while (start<end){
            temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }


    //brute force
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        int last;
        int cur;
        int round=0;
        while (round<k){
            last=nums[len-1];
            for(int i=0;i<len;i++){
                cur=nums[i];
                nums[i]=last;
                last=cur;
            }
            round++;
        }
    }
}
