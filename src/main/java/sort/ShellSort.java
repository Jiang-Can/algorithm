package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/*
* 希尔排序
* 是对InsertSort的一种改进
* 应为插入排序在拍到最后阶段时如果发现较小数字，则需要交换较多次数
*
* */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        Date date1=new Date();
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd1=s1.format(date1);
        System.out.println(sd1);
        shellSort2(arr);
        Date date2=new Date();
        SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd2=s2.format(date2);
        System.out.println(sd2);
        System.out.println(Arrays.toString(arr));


    }
    //交换法的希尔排序
    public static void shellSort(int[] arr){
        int temp=0;
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                for(int j=i-gap;j>=0;j=j-gap){
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
    }
    //移位法的希尔排序
     static void shellSort2(int[] arr){
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=0;i<arr.length-gap;i=i+gap){
                int insertVal=arr[i+gap];
                int insertIndex=i;
                while (insertIndex>=0&&arr[insertIndex]>insertVal){ //判定顺序重要，>=0一定要放在前面
                    arr[insertIndex+gap]=arr[insertIndex];
                    insertIndex-=gap;
                }
                if(insertIndex!=i){
                    arr[insertIndex+gap]=insertVal;
                }
            }
        }
    }
}
