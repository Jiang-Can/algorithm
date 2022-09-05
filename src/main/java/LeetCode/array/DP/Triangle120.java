package LeetCode.array.DP;

import java.io.Closeable;
import java.util.List;
import java.util.stream.Stream;

public class Triangle120 {

    //from top to bottom
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] cache = new int[size*(size+1)/2];
        cache[0] = triangle.get(0).get(0);
        int base = 0;
        int curIndex = 1;

        int res = cache[0];
        for(int i = 1; i<size;i++) {
            res = Integer.MAX_VALUE;
            int n = triangle.get(i).size();
            cache[curIndex] = cache[base] + triangle.get(i).get(0);
            res = Math.min(cache[curIndex++],res);
            for(int j = 1; j < n - 1; j++,curIndex++) {
                cache[curIndex] = Math.min(cache[base+j-1]+triangle.get(i).get(j),
                                           cache[base+j]+triangle.get(i).get(j));
                res = Math.min(cache[curIndex],res);
            }
            cache[curIndex] = cache[base+n-2] + triangle.get(i).get(n-1);
            res = Math.min(cache[curIndex++],res);
            base = base + triangle.get(i-1).size();
        }
        return res;
    }

    // from bottom to top
    public int minimumTotal2(List<List<Integer>> triangle) {
        // this size also equal to the last row size , the extra 1 space is used to initialize the last row
        int[] dp = new int[triangle.size()+1];
        for(int i = triangle.size() - 1; i>=0;i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}
