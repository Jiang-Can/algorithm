package Algorithms;

import java.util.HashMap;

public class HanonTowerDemo {
    public static void main(String[] args) {
        HannonTower(10,'A','B','C');
    }

    public static void HannonTower(int n,char a,char b,char c){
        if(n==1){
            System.out.println(n+": move from "+a+" to "+c);
        }else{
            HannonTower(n-1,a,c,b);
            System.out.println(n+": move from "+a+" to "+c);
            HannonTower(n-1,b,a,c);
        }
    }

}

