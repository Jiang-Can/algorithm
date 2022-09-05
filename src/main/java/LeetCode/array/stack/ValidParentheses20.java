package LeetCode.array.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses20 {
    Stack<Character> stack=new Stack<>();
    public boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<s.length();i++){
            if(!check(s.charAt(i),map))return false;
        }
        return stack.isEmpty();
    }
    private boolean check(char c,HashMap<Character,Character> map){
        if(!map.containsKey(c)){
            stack.push(c);
            return true;
        }else {
            if(!stack.isEmpty()&&stack.peek()==map.get(c)){
                stack.pop();
                return true;
            }else {
                return false;
            }
        }
    }
}
