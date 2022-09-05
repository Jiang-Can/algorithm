package LeetCode.array;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses22 {
    private final StringBuilder temp = new StringBuilder();
    private final List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        construct(1,0,n, new StringBuilder());
        return res;
    }
    private void construct(int left, int right, int n ,StringBuilder temp) {
        if(left < right){
            temp.deleteCharAt(temp.length()-1);
            return;
        }
        if(left < n){
            construct(left+1,right,n, temp.append('('));
        }
        if(right < n){
            construct(left,right+1,n,temp.append(')'));
        }
        if(left == n && right == n){
            res.add(temp.toString());
        }
        if(temp.length()>0){
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
