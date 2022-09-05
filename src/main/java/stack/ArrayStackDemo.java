package stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack s=new ArrayStack(5);
        for(int i=0;i<5;i++){
            s.push(i+1);
        }
        s.list();
        System.out.println();
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println();
        s.list();

    }
}
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }
    //栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int num){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        stack[++top]=num;
    }
    public int pop(){
        if(isEmpty())
            throw new RuntimeException("stack is empty");
        int value=stack[top];
        top--;
        return value;
    }
    public void list(){
        if(isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.println(stack[i]);
        }
    }
}