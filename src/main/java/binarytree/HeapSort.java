package binarytree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {

        int[] arr=new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000000);
        }
        Date date1=new Date();
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd1=s1.format(date1);
        System.out.println(sd1);
        heapSort(arr,arr.length);
        Date date2=new Date();
        SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd2=s2.format(date2);
        System.out.println(sd2);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] tree,int n){
        buildHeap(tree,n);
        for(int i=n-1;i>=0;i--){
            swap(tree,i,0);
            heapify(tree,i,0);
        }
    }
    public static void swap(int[] tree,int i,int j){
        int temp=tree[i];
        tree[i]=tree[j];
        tree[j]=temp;
    }
    public static void buildHeap(int[] tree,int n){
        int last=n-1;
        int parent=(last-1)/2;
        for(int i=parent;i>=0;i--){
            heapify(tree,n,i);
        }
    }
    public static void heapify(int[] tree,int n,int i){
        int c1=2*i+1;
        int c2=2*i+2;
        if(i>=n){
            return;
        }
        int max=i;
        if(c1<n&&tree[c1]>tree[max]){
            max=c1;
        }
        if(c2<n&&tree[c2]>tree[max]){
            max=c2;
        }
        if(max!=i){
            swap(tree,i,max);
            heapify(tree,n,max);
        }

    }
}
