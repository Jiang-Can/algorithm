package LeetCode.array.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LetterCombinationsPhoneNumber17 {
    private List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        String[] keys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combine(keys,digits,0,new Stack<>());
        return res;
    }
    private void combine(String[] keys, String digits, int position, Stack<Character> subStr) {
        if(position>=digits.length()) {
            res.add(getString(subStr));
            return;
        }
        String key = keys[digits.charAt(position) - '0'];
        for(int i = 0; i<key.length(); i++) {
            subStr.push(key.charAt(i));
            combine(keys,digits,position+1,subStr);
            subStr.pop();
        }

    }
    private String getString(List<Character> subStr) {
        StringBuilder sb = new StringBuilder();
        for(Character c: subStr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
