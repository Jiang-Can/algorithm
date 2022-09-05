package LeetCode.array;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String pattern = "ababcabaa";
        String text = "ababababcabaababcabaaaaababcabaa";
        KMP kmp = new KMP();
        System.out.println(kmp.KMPMatch(pattern.toCharArray(), text.toCharArray()));
    }

    public int KMPMatch(char[] pattern, char[] text) {
        int i = 0; //text index
        int j = 0;  //pattern index
        int n = text.length, m = pattern.length;
        int count = 0;
        int[] pTab = prefixTableGenerator(pattern);
        while (i < n) {
            if (j != -1) {
                if (text[i] == pattern[j] && j == m - 1) {
                    count++;
                    j = pTab[j];
                } else if (text[i] == pattern[j]) {
                    i++;
                    j++;
                } else {
                    j = pTab[j];
                }
            } else {
                i++;
                j = 0;
            }
        }
        return count;
    }

    public int[] prefixTableGenerator(char[] pattern) {
        int[] pTab = new int[pattern.length];
        int len = 0;
        int i = 1;
        while (i < pattern.length) {
            if (pattern[len] == pattern[i]) {
                len++;
                pTab[i++] = len;
            } else {
                if (len > 0) {
                    len = pTab[len - 1];
                } else {
                    i++;
                }
            }
        }
        if (pattern.length - 1 >= 0) {
            System.arraycopy(pTab, 0, pTab, 1, pattern.length - 1);
        }
        pTab[0] = -1;
        return pTab;
    }
}
