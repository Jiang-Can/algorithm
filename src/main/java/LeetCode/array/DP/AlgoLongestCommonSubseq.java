package LeetCode.array.DP;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AlgoLongestCommonSubseq {

    public static void main(String[] args) {
        AlgoLongestCommonSubseq.longestCommonSubsequence("ZXVVYZW","XKYKZPW");
    }
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        int m = str2.length();
        int n = str1.length();
        if(n==0||m==0)return new ArrayList<Character>();
        StringBuilder[][] dp = new StringBuilder[m][n];

        dp[0][0] = new StringBuilder();
        if(str1.charAt(0)==str2.charAt(0)){

            dp[0][0].append(str1.charAt(0));
        }
        boolean flag = dp[0][0].length()==0;
        for(int i = 1;i<n;i++){
            dp[0][i] = new StringBuilder();
            if(str1.charAt(i)==str2.charAt(0)&&flag){
                dp[0][i].append(str2.charAt(0));
                flag = false;
            }
            dp[0][i].append(dp[0][i-1]);
        }
        flag = dp[0][0].length()==0;
        for(int i = 1;i<m;i++){
            dp[i][0] = new StringBuilder();
            if(str2.charAt(i)==str1.charAt(0)&&flag){
                dp[i][0].append(str1.charAt(0));
                flag = false;
            }
            dp[i][0].append(dp[i-1][0]);
        }

        boolean mark;
        for(int i = 1;i<m;i++){
            mark = true;
            for(int j = 1;j<n;j++){
                dp[i][j] = new StringBuilder();
                dp[i][j].append(dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1]);
                if(str1.charAt(j)==str2.charAt(i)&&mark){
                  dp[i][j].append(str1.charAt(j));
                  mark = false;
                }
            }
        }
        return transform(dp[m-1][n-1]);
    }

    private static List<Character> transform(StringBuilder s){
        List<Character> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            res.add(s.charAt(i));
        }
        return res;
    }

}
