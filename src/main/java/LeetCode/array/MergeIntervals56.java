package LeetCode.array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> merged=new LinkedList<>();
        for(int[] interval:intervals){
            if(merged.isEmpty()||merged.getLast()[1]<interval[0]){
                merged.add(interval);
            }else{
                merged.getLast()[1]=Math.max(interval[1],merged.getLast()[1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}