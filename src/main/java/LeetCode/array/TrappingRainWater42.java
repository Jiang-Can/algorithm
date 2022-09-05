package LeetCode.array;

public class TrappingRainWater42 {

    //dp solution
    public int trap(int[] height) {
        int max=0;
        int[] dp=new int[height.length];
        for(int i=0;i<height.length;i++){
            max= Math.max(height[i], max);
            dp[i]=max;
        }
        max=0;
        int res=0;
        for(int i=height.length-1;i>=0;i--){
            max=Math.max(max, height[i]);
            dp[i]=Math.min(max,dp[i]);
            res+=dp[i]>height[i]?(dp[i]-height[i]):0;
        }
        return res;
    }


    //two pointers
    public int trap1(int[] height) {
        if(height.length<=2)return 0;
        int res=0,l=0,r=height.length-1,leftHeight=height[l],rightHeight=height[r];
        while (l<r){
            if(leftHeight<rightHeight){
                res+=leftHeight-height[l++];
                leftHeight=Math.max(leftHeight,height[l]);

            }else {
                res+=rightHeight-height[r--];
                rightHeight=Math.max(rightHeight,height[r]);

            }
        }
        return res;
    }

    //stack solution

}
