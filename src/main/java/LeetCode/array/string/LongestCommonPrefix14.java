package LeetCode.array.string;

public class LongestCommonPrefix14 {
    public String longestCommonPrefix2(String[] strs) {
        int i = 0;
        char cur;
        boolean flag = true;
        while (flag) {
            if (i >= strs[0].length()) break;
            cur = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || str.charAt(i) != cur) {
                    flag = false;
                    break;
                }
            }
            i = flag ? i + 1 : i;
        }
        return strs[0].substring(0, i);
    }

    public String longestCommonPrefix(String[] strs) {
        int index = strs[0].length();
        int position = 0, curIndex;
        for (int i = 1; i < strs.length; i++) {
            curIndex = sameUntil(strs[i - 1], strs[i], index);
            if (curIndex < index) {
                index = curIndex;
                position = i;
            }
        }
        return strs[position].substring(0, index);
    }

    private int sameUntil(String pre, String cur, int maxIndex) {
        for (int i = 0; i < cur.length() && i < maxIndex; i++) {
            if (cur.charAt(i) != pre.charAt(i)) {
                return i;
            }
        }
        return Math.min(maxIndex, cur.length());
    }
}
