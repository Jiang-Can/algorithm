package LeetCode.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubNoRepeatChar3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0, max = 0;
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                max = Math.max(end - start + 1, max);
                end++;
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return max;
    }
}
