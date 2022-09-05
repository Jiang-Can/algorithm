package Algorithms.KMP;


public class KMP {
    public static void main(String[] args) {
        String strPattern="ABABCABAA";
        String strSource="ABABABABCABAAB";
        char[] pattern=strPattern.toCharArray();
        char[] source= strSource.toCharArray();
        int[] prefix=generatePrefix(pattern);
        for(int i=prefix.length-1;i>0;i--){
            prefix[i]=prefix[i-1];
        }
        prefix[0]=-1;
        KMPSearch(prefix,source,pattern);
    }
    public static void KMPSearch(int[] prefix,char[] source,char[] pattern){
        int i=0;// the pointer of prefix
        int j=0;// the pointer of source
        int m=prefix.length;
        int n=source.length;
        int count=0;
        while(j<n){
            if(i==m-1&&pattern[i]==source[j]){
                System.out.println("match "+ (++count) + " times"+ " at "+(j-m+1));
                j++;
                i=prefix[i];
            }else if(source[j]==pattern[i]){
                i++;
                j++;
            }else{
                i=prefix[i];
                if(i==-1){
                    i++;j++;
                }
            }
        }
    }
    public static int[] generatePrefix(char[] pattern) {
        int n = pattern.length;
        int[] prefix = new int[n];
        prefix[0] = 0;
        int i = 1;
        int len = 0;
        while (i < n) {
            if (pattern[i] == pattern[len]) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    len = prefix[len];
                    i++;
                }
            }
        }
        return prefix;
    }
}
