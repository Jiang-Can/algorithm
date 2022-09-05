package stack;
import java.lang.Math;
public class Calculator {
    public static void main(String[] args) {
        String expression="30+2*6-2";
        ArrayStack2 numStack=new ArrayStack2(10);
        ArrayStack2 operStack=new ArrayStack2(10);
        int num1;
        int num2;
        int oper;
        int res;
        char value=' ';
        String keepNum="";

        for(int i=0;i<expression.length();i++){
            value=expression.charAt(i);
            if(operStack.isOper(value)){  //是操作符
                if(!operStack.isEmpty()){ //操作栈非空
                    if(operStack.priority(value)<=operStack.topValue()){//准备入栈操作符优先级小于等于栈顶
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=operStack.cal(num1,num2,(int)oper);
                        numStack.push(res);
                        operStack.push(value);
                    }else
                    operStack.push((int)value);
                }else{//操作栈为空
                    operStack.push((int)value);
                }
            }else{//是数字
                keepNum+=value;
                if(i<expression.length()-1){
                    if(numStack.isOper(expression.charAt(i+1))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }else{
                    numStack.push(Integer.parseInt(keepNum));
                }

            }
        }
        while(!operStack.isEmpty()){
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=operStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println(numStack.pop());
    }
}
class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public int getTop() {
        return top;
    }


    public ArrayStack2(int maxSize){
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
    //返回运算符的优先级
    public int priority(int oper){
        if (oper == '*' || oper == '/') {
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else
            return -1;
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //返回栈顶值
    public int topValue(){
        return priority(stack[top]);
    }

    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':res=num2+num1;break;
            case '-':res=num2-num1;break;
            case '*':res=num2*num1;break;
            case '/':res=num2/num1;break;
            default:break;
        }
        return res;
    }
}
