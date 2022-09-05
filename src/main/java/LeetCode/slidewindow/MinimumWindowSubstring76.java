package LeetCode.slidewindow;

import java.util.*;

public class MinimumWindowSubstring76 {

    public static void main(String[] args) {
        MinimumWindowSubstring76 minimumWindowSubstring76 = new MinimumWindowSubstring76();
        System.out.println(minimumWindowSubstring76.minWindow("ADOBECODEBANC"
                ,"ABC"));

    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> template = new HashMap<>();
        for (char c:t.toCharArray()) {
            template.put(c,template.get(c)==null?1:template.get(c)+1);
        }
        Map<Character, Integer> map = new HashMap<>();
        int tLen = t.length();
        int sLen = s.length();
        int head = 0, tail = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int i = -1, j = -1;
        Character c;
        while (tail < sLen && count != tLen) {
            c = s.charAt(tail);
            if (template.containsKey(c)) {
                map.put(c,map.get(c)==null?1:map.get(c)+1);
                if (map.get(c)<=(template.get(c))) {
                    count++;
                }
            }

            while (count == tLen) {
                if (tail - head < minLen) {
                    i = head;
                    j = tail;
                    minLen = tail - head;
                }
                c = s.charAt(head);
                if (template.get(c) != null) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c)<(template.get(c))) {
                        count--;
                        head++;
                        break;
                    }
                }
                if (head < tail) {
                    head++;
                } else {
                    break;
                }
            }

            tail++;
        }
        return i == -1 ? "" : s.substring(i, j + 1);
    }
}
