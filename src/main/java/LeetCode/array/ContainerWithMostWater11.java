package LeetCode.array;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int maxArea=0;
        int l=0,r=height.length-1;
        while (l<r){
            if(height[l]<height[r]){
                maxArea= Math.max(maxArea, (r - l) * height[l]);
                l++;
            }else {
                maxArea= Math.max(maxArea, (r - l) * height[r]);
                r--;
            }
        }
        return maxArea;
    }
}
