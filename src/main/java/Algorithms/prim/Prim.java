package Algorithms.prim;


import java.util.ArrayList;
import java.util.HashMap;


public class Prim {
    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int [][] weight={{1000,5,7,1000,1000,1000,2},
                         {5,1000,1000,9,1000,1000,3},
                         {7,1000,1000,1000,8,1000,1000},
                         {1000,9,1000,1000,1000,4,1000},
                         {1000,1000,8,1000,1000,1000,5,4},
                         {1000,1000,1000,4,5,1000,6},
                         {2,3,1000,1000,4,6,1000}};
        primeShowPath(vertex,weight,0);

    }
    public static void primeShowPath(char[] vertex,int[][] weight,int start){
        ArrayList<String> order=new ArrayList<>();
        boolean[] selected=new boolean[vertex.length];
        selected[start]=true;

        while (selectedAll(selected)){
            int minWeight=1000;
            int minPi=0;
            int minPj=0;
            for(int i=0;i<weight.length;i++){
                if(selected[i]){
                    for(int j=0;j<weight[0].length;j++){
                        if(weight[i][j]<minWeight){
                            minWeight=weight[i][j];
                            minPi=i;
                            minPj=j;
                        }
                    }
                }
            }
            weight[minPi][minPj]=1000;
            weight[minPj][minPi]=1000;
            if(!(selected[minPi]&&selected[minPj])){
                order.add(vertex[minPi]+"->"+vertex[minPj]);



                selected[minPj]=true;
                selected[minPi]=true;
            }



        }
        System.out.println(order);

    }
    public static boolean selectedAll(boolean[] select){
        for(boolean flag:select){
            if(!flag){
                return true;
            }
        }
        return false;
    }
}
