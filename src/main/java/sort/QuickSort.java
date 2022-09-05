package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        Date date1=new Date();
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd1=s1.format(date1);
        System.out.println(sd1);
        quickSort(arr,0,arr.length-1);
        Date date2=new Date();
        SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd2=s2.format(date2);
        System.out.println(sd2);
            System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left>=right)
            return;
        int temp=0;
        int l=left;
        int r=right;
        int key=arr[left];
        while (l!=r){
            //先从右边开始找,因为比较是取最左边的值，如果先从左边开始找，
            while(arr[r]>=key&&l<r){
                --r;
            }
            while (arr[l]<=key&&l<r){
                ++l;
            }
            if(l<r){
                temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
        }
        //当l=r,把key值归位
        arr[left]=arr[l];
        arr[l]=key;
        quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);
    }
    public static void qs(int[] arr,int left,int right){
        if(right<left){
            return;
        }
        int temp=0;
        int l=left;
        int r=right;
        int key=arr[left];
        while (l!=r){
            while (l<r&&arr[l]<=key){
                l++;
            }
            while (l<r&&arr[r]>=key){
                r++;
            }
            if(l<r){
                temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
        }
        arr[left]=arr[l];
        arr[l]=key;
        qs(arr,left,l-1);
        qs(arr,l+1,right);

    }
}

