package LeetCode.array.stack;


import java.util.Stack;

public class MinStack {
    Stack<Long> stack=new Stack<>();
    long min;
    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else {
            stack.push(x-min);
            if(x-min<0){ //means x is new min num
                min=x;
            }
        }
    }

    public void pop() {
        long pop=stack.pop();
        if(pop<0){
            min=min-pop;
        }
    }

    public int top() {
        if(stack.peek()>=0){
            return (int) (min+stack.peek());
        }else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}
