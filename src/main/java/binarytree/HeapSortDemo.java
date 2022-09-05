package binarytree;

import java.util.Arrays;

public class HeapSortDemo {

    public static void main(String[] args) {
        /*int[] arr=new int[100];
        for(int i=0;i<100;i++){
            arr[i]=(int)(Math.random()*100);
        }
        heapSort(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));*/


        System.out.println("strsdfs".contains("sdfss"));
    }
    public static void swap(int[] tree,int i,int j){
        int temp;
        temp=tree[i];
        tree[i]=tree[j];
        tree[j]=temp;
    }
    public static void heapSort(int[]tree,int n){
        for(int i=n;i>0;i--){
            buildHeap(tree,i);
            swap(tree,0,i);
        }
    }

    public static void buildHeap(int[]tree,int  n){
        int lastParent=(n-1)/2;
        for(int i=lastParent;i>=0;i--){
             heapFy(tree,n,i);
        }
    }
    public static void heapFy(int[] tree,int n,int i){
        int c1=2*i+1;
        int c2=2*i+2;
        int max=i;
        if(c2>n){
            return;
        }
        if(tree[c1]>tree[max]){
            max=c1;
        }
        if(tree[c2]>tree[max]){
            max=c2;
        }
        if(i!=max){
            swap(tree,i,max);
            heapFy(tree,n,max);
        }

    }
}
