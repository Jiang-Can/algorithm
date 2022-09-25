package LeetCode.array.DP;

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence673 {

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n <= 1) {
            return 1;
        }
        int maxLen = 0;
        int res;
        res = nums[0] < nums[1]? 0: 1;
        int[] dpSum = new int[n];
        int[] dpLen = new int[n];
        for(int i = 1; i < n; i++) {
            int rec = 1;
            int curMax = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(curMax < dpLen[j] + 1) {
                        curMax = dpLen[j] + 1;
                        dpLen[i] = curMax;
                        rec = dpSum[j] == 0? 1: dpSum[j];
                    } else if(curMax == dpLen[j] + 1) {
                        rec += dpSum[j];
                    }
                }
            }
            dpSum[i] = rec;
            if(maxLen < dpLen[i]) {
                maxLen = dpLen[i];
                res = rec;
            } else if(maxLen == dpLen[i]) {
                res += rec;
            }

        }
        return res;
    }

    //fill with 1 solution
    public int findNumberOfLISWith1(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int res = 1;
        int[] dpSum = new int[n];
        int[] dpLen = new int[n];
        Arrays.fill(dpSum, 1);
        Arrays.fill(dpLen, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dpLen[i] < dpLen[j] + 1) {
                        dpLen[i] = dpLen[j] + 1;
                        dpSum[i] = dpSum[j];
                    } else if(dpLen[i] == dpLen[j] + 1) {
                        dpSum[i] += dpSum[j];
                    }
                }
            }
            if(maxLen < dpLen[i]) {
                maxLen = dpLen[i];
                res = dpSum[i];
            } else if(maxLen == dpLen[i]) {
                res += dpSum[i];
            }

        }
        return res;
    }

}
