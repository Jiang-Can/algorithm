package Algorithms.dp2;

import java.util.Arrays;

public class Dp2 {
    public static void main(String[] args) {
        int[] arr={1,2,4,1,7,8,3};
        System.out.println(recOpt(arr,arr.length-1));
        System.out.println(Arrays.toString(Opt(arr)));
    }
    public static int recOpt(int[] arr,int i){
        if(i==0){
            return arr[0];
        }else if(i==1){
            return Math.max(arr[0],arr[1]);
        }else{
            int A=recOpt(arr,i-1);
            int B=recOpt(arr,i-2)+arr[i];
            return Math.max(A,B);
        }
    }
    public static int[] Opt(int[] arr){
        int[] optArr=new int[arr.length];
        optArr[0]=arr[0];
        optArr[1]=Math.max(arr[0],arr[1]);
        for(int k=2;k<arr.length;k++){
            int A=optArr[k-1];
            int B=optArr[k-2]+arr[k];
            optArr[k]=Math.max(A,B);
        }
        return optArr;
    }


}
