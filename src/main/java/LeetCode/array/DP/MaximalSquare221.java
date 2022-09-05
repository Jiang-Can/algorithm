package LeetCode.array.DP;

public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        int max=0;boolean flag=true;
        for(int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0]-'0';
            if(flag&&dp[i][0]==1){max=1;flag=false;}
        }
        for(int i=0;i<matrix[0].length;i++){
            dp[0][i]=matrix[0][i]-'0';
            if(flag&&dp[0][i]==1){max=1;flag=false;}
        }

        //find  the  smallest square in left and up and diagnose cells
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    max=Math.max(dp[i][j]*dp[i][j],max);
                }
            }
        }
        return max;
    }

    public int maximalSquare2(char[][] matrix) {
        int[] dp = new int[matrix[0].length];
        int max = 0;
        int prev;
        for(int i = 0; i< matrix.length; i++) {
            prev = dp[0];
            dp[0] = matrix[i][0] - '0';
            max = Math.max(dp[0],max);
            for(int j = 1; j<matrix[i].length; j++) {
                int temp = dp[j];
                if(matrix[i][j] == '1') {
                    dp[j] = Math.min(Math.min(dp[j],dp[j-1]),prev) + 1;
                    max = Math.max(max,dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return max*max;
    }


}
