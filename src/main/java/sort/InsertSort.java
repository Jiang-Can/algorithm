package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        Date date1=new Date();
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd1=s1.format(date1);
        System.out.println(sd1);
        insertSort(arr);
        Date date2=new Date();
        SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd2=s2.format(date2);
        System.out.println(sd2);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int insertValue=arr[i+1];
            int insertIndex=i;
            while(insertIndex>=0&&insertValue<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex!=i){
                arr[insertIndex+1]=insertValue;
            }

        }
    }
}
