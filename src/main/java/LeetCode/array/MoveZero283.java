package LeetCode.array;

public class MoveZero283 {

    public void moveZeros(int[] nums){
        int temp;
        for(int explore=0,anchor=0;explore<nums.length;explore++){
            if(nums[explore]!=0){
                temp=nums[explore];
                nums[explore]=nums[anchor];
                nums[anchor++]=temp;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int nextNZS=0;
        int nextNZE;
        int i=0; //index of after swap
        boolean flag=true;
        while (nextNZS< nums.length){
            //start of 0, also move next all not zero subArr start from this point
            if(nums[nextNZS]==0){
                if(flag){
                    i=nextNZS;
                    flag=false;
                }
                while (nextNZS <nums.length&&nums[nextNZS]==0){
                    nextNZS++;
                }
                //now nextNotZeroStart has set, find end to determine the length of next not zero subArr
                //if nextNZS has already equal to length,loop is over
                if(nextNZS <nums.length&&nums[nextNZS]!=0){
                     nextNZE=nextNZS+1;
                     while (nextNZE<nums.length&&nums[nextNZE]!=0){
                         nextNZE++;
                     }
                     while (nextNZS<nextNZE){
                         nums[i++]=nums[nextNZS];
                         nums[nextNZS++]=0;
                     }
                }
            }else{
                nextNZS++;
            }
        }
    }
}
