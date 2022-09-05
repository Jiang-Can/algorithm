package linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("alice");
        stack.add("bob");
        stack.push("cindy");

        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
