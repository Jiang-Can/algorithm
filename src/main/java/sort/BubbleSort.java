package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        int []arr =new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        Date date1=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1str=sdf.format(date1);
        System.out.println(date1str);

        boolean flag=false;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
                if(!flag)
                    break;
            }
        }
        Date date2=new Date();
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2str=sdf2.format(date2);
        System.out.println(date2str);
    }
}
