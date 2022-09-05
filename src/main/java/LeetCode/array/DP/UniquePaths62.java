package LeetCode.array.DP;

import java.util.Arrays;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1)return 1;
        int N=m+n-2;
        int M=m<n?m-1:n-1;
        long res=1;
        //这里不能直接算会越界
        for(int i=N,j=1;i>N-M;i--,j++){
            res*=i;
            res/=j;
        }
        return (int)res;
    }

    //dp
    public int uniquePaths2(int m, int n) {
        int[][] path=new int[m][n];
        for(int i=0;i<n;i++){
            path[0][i]=1;
        }
        for(int i=0;i<m;i++){
            path[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                path[i][j]=path[i-1][j]+path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }


}
