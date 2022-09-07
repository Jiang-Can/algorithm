package LeetCode.array.DP;

public class OnesAndZeros474 {
    public static void main(String[] args) {
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String str: strs) {
            int[] value = handleStr(str);
            for(int i = m; i>=value[0]; i--) {
                for(int j = n; j>=value[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-value[0]][j-value[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] handleStr(String str) {
        int[] res = new int[2];
        for(int i = 0; i< str.length(); i++) {
            if(str.charAt(i) == '0') {
                res[0] ++;
            }else {
                res[1] ++;
            }
        }
        return res;
    }
}
