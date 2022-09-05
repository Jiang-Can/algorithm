package LeetCode.array.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgoMaxSumIncreasingSubsequence {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        int n = array.length;
        Record max;
        int maxRes = array[0];
        int maxIndex = 0;
        Record[] dp = new Record[n];
        for(int i = 0;i<n;i++){
            max = new Record(Integer.MIN_VALUE);
            for(int j = 0;j<i;j++){
                if(array[i]>array[j]&&max.value<array[i]+dp[j].value){
                    max.value = array[i]+dp[j].value;
                    max.comb = new ArrayList<>(dp[j].comb);
                    max.comb.add(array[i]);
                }
            }
            if(max.value<array[i]){
                max.value = array[i];
                max.comb = new ArrayList<>();
                max.comb.add(array[i]);
            }
            if(maxRes<max.value){
                maxIndex = i;
                maxRes = max.value;
            }
            dp[i] = max;
        }
        List<List<Integer>> res = new ArrayList<>();
        //res.add(List.of(dp[maxIndex].value));
        res.add(dp[maxIndex].comb);
        return res;
    }
}
class Record{
    int value;
    List<Integer> comb;

    public Record(int value) {
        this.value = value;
    }

    public Record(int value, List<Integer> comb) {
        this.value = value;
        this.comb = comb;
    }
}
