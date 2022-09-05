package LeetCode.array.DP;

import java.util.Arrays;

public class MaximalRectangle85 {
    public static void main(String[] args) {
        int i,j;
        i=j=2;
        System.out.println(i+","+j);
    }
    public int maximalRectangle(char[][] matrix) {
        Node[][] nodes=new Node[matrix.length][matrix[0].length];
        for(Node[] ns:nodes){
            Arrays.fill(ns,new Node());
        }
        int max=0;
        if(matrix[0][0]=='1'){nodes[0][0].maxLeft=nodes[0][0].maxUp=1;max=1;}
        for(int i=1;i<matrix.length;i++){
            if(matrix[i-1][0]=='1'){
                nodes[i][0].maxUp =nodes[i-1][0].maxUp +1;
                max=Math.max(max, nodes[i][0].maxUp);
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i-1]=='1'){
                nodes[0][i].maxLeft  =nodes[0][i-1].maxLeft +1;
                max=Math.max(max, nodes[0][i].maxLeft);
            }
        }
        int left,up;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]=='1') {
                    nodes[i][j].maxUp = nodes[i - 1][j].maxUp + 1;
                    nodes[i][j].maxLeft = nodes[i][j - 1].maxLeft + 1;
                    left=Math.min(nodes[i][j].maxUp, nodes[i][j-1].maxUp);
                    up=Math.min(nodes[i][j].maxLeft,nodes[i-1][j].maxLeft);
                    max=Math.max(Math.max(left*up,max),Math.max( nodes[i][j].maxUp, nodes[i][j].maxLeft));
                }
            }
        }
        return max;
    }
    class Node{
        int maxLeft =0;
        int maxUp =0;
    }
}
