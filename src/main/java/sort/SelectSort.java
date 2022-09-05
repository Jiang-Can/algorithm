package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        Date date1=new Date();
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ds1=s1.format(date1);
        System.out.println(ds1);
        selectS(arr);
        Date date2=new Date();
        SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ds2=s2.format(date2);
        System.out.println(ds2);
    }
    //选择排序
    public static void selectS(int[]arr){

        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }

        }

    }
}
