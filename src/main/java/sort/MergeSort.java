package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr=new int[800000];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*8000000);
        }
        int[] temp=new int[arr.length];
        Date date1=new Date();
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd1=s1.format(date1);
        System.out.println(sd1);
        mergeSort(arr,0,arr.length-1,temp);
        Date date2=new Date();
        SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd2=s2.format(date2);
        System.out.println(sd2);
        System.out.println(Arrays.toString(arr));

    }
    private static void mergeSort(int[]arr,int left,int right,int[] temp){
        if(left<right){
            int mid= (left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;

        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                ++t;
                ++i;
            }else{
                temp[t]=arr[j];
                ++t;
                ++j;
            }
        }

        while(i<=mid){
            temp[t]=arr[i];
            ++i;
            ++t;
        }
        while(j<=right){
            temp[t]=arr[j];
            ++j;
            ++t;
        }
        //复制temp到arr上
        t=0;
        int tempLeft=left;
        while(tempLeft<=right){
            arr[tempLeft]=temp[t];
            ++t;
            ++tempLeft;
        }
    }
    public static void ms(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            ms(arr,left,(left+mid)/2,temp);
            ms(arr,mid+1,right,temp);

        }
    }
    public static void m(int[] arr,int left,int mid,int right,int[] temp){
        int l=left;
        int r=mid+1;
        int t=left;
        while (l<=mid&&r<=right){
            if(arr[l]<=arr[r]){
                temp[t]=arr[l];
                t++;
                l++;
            }else{
                temp[t]=arr[r];
                r++;
                t++;
            }
        }
        while (l<=mid){
            temp[t]=arr[l];
            t++;
            l++;
        }
        while (r<=right){
            temp[t]=arr[r];
            t++;
            r++;
        }
        t=0;
        while(left<=right){
            arr[left++]=temp[t++];
        }

    }
}
