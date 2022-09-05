package LeetCode.array.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures739 {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] T) {
        int[] ans=new int[T.length];
        Stack<Integer> stack=new Stack<>();
        int pop;
        for(int i=0;i<T.length;i++){
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                pop=stack.pop();
                ans[pop]=i-pop;
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] ans=new int[T.length];
        for(int i=0;i<T.length-1;i++){
            for(int j=i+1;j<T.length;j++){
                if(T[j]>T[i]){
                    ans[i]=j-i;
                    break;
                }
            }
        }
        return ans;
    }
}
