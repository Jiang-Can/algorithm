package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr=new int[8000000];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*80000000);
        }

        Date date1=new Date();
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd1=s1.format(date1);
        System.out.println(sd1);

        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //直接得出数字位数
        int step=(max+"").length();
        //放0-9的桶
        int[][] bucket= new int[10][arr.length];
        //每个桶的指针
        int[] digitIndex=new int[10];



        for(int i=0,n=1;i<step;i++,n*=10){
            //把数字同一位相同的放到同一个桶中
            for (int value : arr) {
                int digit = value / n % 10;
                bucket[digit][digitIndex[digit]] = value;
                ++digitIndex[digit];
            }
            int j=0;
            //按该位数字大小从小到大遍历
            for(int k=0;k<10;k++){
                if(digitIndex[k]!=0){
                    for(int l=0;l<digitIndex[k];l++){
                        arr[j++]=bucket[k][l];
                    }
                    //把指针归0
                    digitIndex[k]=0;
                }
            }
        }

        Date date2=new Date();
        SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd2=s2.format(date2);
        System.out.println(sd2);

        System.out.println(Arrays.toString(arr));
    }
}
