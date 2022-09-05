package Algorithms.dp2;


import java.util.*;

public class DpSum {
    public static void main(String[] args) {
        int[] arr={3,34,4,12,5,2};
        System.out.println(subset(arr,13));

    }
    public int ret(){
        return 0;
    }
    public static boolean ocSubset(int[] arr,int i,int s){
        if(s==0){
            return true;
        }else if(i==0){
            return s==arr[0];
        }else if(s<arr[i]){
            return ocSubset(arr,i-1,s);
        }else{
            boolean A=ocSubset(arr,i-1,s-arr[i]);//选
            boolean B=ocSubset(arr,i-1,s);//不选
            return A || B;
        }
    }

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        Arrays.sort(intervals, Comparator.comparingInt((int[] array) -> array[0]));
        List<int[]> res = new LinkedList<>();

        res.add(new int[]{1,2});

        return res.toArray(new int[][]{});
    }
    public static boolean subset(int[] arr,int s){
        boolean[][] boolArr=new boolean[arr.length][s+1];
        for(int k=0;k<arr.length;k++){
            boolArr[k][0]=true;
        }

        if(arr[0]<=s){
            boolArr[0][arr[0]]=true;
        }
        for(int r=1;r<boolArr.length;r++){
            for(int c=1;c<boolArr[0].length;c++){
                if(arr[r]>c){
                    boolArr[r][c]=boolArr[r-1][c];
                }else{
                    boolean A=boolArr[r-1][c];
                    boolean B=boolArr[r-1][c-arr[r]];
                    boolArr[r][c]=A||B;
                }
            }
        }


        return boolArr[arr.length-1][s];
    }

}
