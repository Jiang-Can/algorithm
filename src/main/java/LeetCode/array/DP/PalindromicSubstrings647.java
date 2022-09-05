package LeetCode.array.DP;

public class PalindromicSubstrings647 {
    public int bruteForce(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                count+=isPalindrome(s,i, j)?1:0;
            }
        }
        return count;
    }
    private boolean isPalindrome(String s,int start,int end){
        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //dp method
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int res=0;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(dp[i][j]=(s.charAt(i)==s.charAt(j))&&(j-i+1<3||dp[i+1][j-1]))
                    res++;
            }
        }
        return res;
    }


}
