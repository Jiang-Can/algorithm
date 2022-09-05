package LeetCode.array.DP;

public class LongestPalindromicSub5 {
    public static void main(String[] args) {
        System.out.println("123".substring(0, 3));
        longestPalindromicSubstring("aca");
    }
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        String max = "";
        String s1,s2;
        for(int i = 0;i<str.length();i++){
            s1 = find(str,i,i);
            s2 = find(str,i,i+1);
            s1 = s1.length()>s2.length()?s1:s2;
            max = max.length()>s1.length()?max:s1;
        }
        return max;
    }
    private static String find(String str,int l,int r){
        while(l>=0&&r<str.length()&&str.charAt(l)==str.charAt(r)){
            l--;
            r++;
        }
        l++;
        r--;
        if(l>r){
            return "";
        }else{
            return str.substring(l,r);
        }
    }
}

