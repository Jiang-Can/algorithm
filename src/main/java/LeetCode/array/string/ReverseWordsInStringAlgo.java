package LeetCode.array.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseWordsInStringAlgo {

    public static void main(String[] args) {
        ReverseWordsInStringAlgo reverseWordsInStringAlgo = new ReverseWordsInStringAlgo();
        System.out.println(reverseWordsInStringAlgo.reverseWordsInString("..H,, hello 678"));
        System.out.println(false^true);

    }
    public String reverseWordsInString(String string) {
        // Write your code here.

        if(string.length()<=1)return string;
        Stack<String> words = new Stack<>();
        StringBuilder res = new StringBuilder();
        int start = 0, end = 0;
        boolean space = false;
        while (end < string.length()) {
            end++;
            if (end >= string.length() || (string.charAt(end) == ' ' ^ space)) {
                words.push(string.substring(start,end));
                start = end;
                space = !space;
            }
        }

        while (!words.isEmpty()){
            res.append(words.pop());
        }

        return res.toString();
    }
}
