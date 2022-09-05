package LeetCode.array;

public class SortColors75 {
    public void sortColors(int[] nums) {
        int zero=0,one=0;
        for (int num : nums) {
            if (num == 0) zero++;
            if (num == 1) one++;
        }
        int i=0;
        while (i<zero){
            nums[i++]=0;
        }
        while (i<zero+one){
            nums[i++]=1;
        }
        while (i<nums.length){
            nums[i++]=2;
        }
    }
    public void sortColors2(int[] nums){
        int p0=0,p2=nums.length-1,i=0;

        while (i<=p2){
            // 扫到0的时候没有执行 i-- 是因为在i之前的所以数字都被扫描过，被换过来的一定是1
            if(nums[i]==0){
                nums[i]=nums[p0];
                nums[p0]=0;
                p0++;
            }
            // 而扫到2的时候是与未扫描的数字进行交换所以可能为任意数，所以需要让i留在原位置继续扫描
            if(nums[i]==2){
                nums[i]=nums[p2];
                nums[p2]=2;
                p2--;
                i--;
            }
            i++;
        }
    }

}
