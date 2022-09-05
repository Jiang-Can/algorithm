package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String expression="1+((20+3)x4)-5";
        List<String> list=toInffixList(expression);
        List<String> suffixExpression=toSuffixExpression(list);
        System.out.println(cal(suffixExpression));
    }

    public static List<String> getListString(String suff){
        //把suffix分割
        String[] split=suff.split(" ");
        List<String> list=new ArrayList<String>();
        for(String ele:split){
            list.add(ele);
        }
        return list;
    }

    //把中缀表达式转为对应List
    public static List<String> toInffixList(String ls){
        List<String> list=new ArrayList<>();
        int i=0;
        String str;
        do{
            if(ls.charAt(i)<48||ls.charAt(i)>57){ //char 不是0-9
                list.add(ls.charAt(i)+"");
                i++;
            }else{
                str="";
                while((i<ls.length())&&(ls.charAt(i)>=48&&ls.charAt(i)<=57)){ //char是数字
                    str+=ls.charAt(i);
                    i++;
                }
                list.add(str);
            }
        }while (i<ls.length());
        return list;
    }
    //中缀表达式转后缀表达式
    public static List<String> toSuffixExpression(List<String> ls){
        //定义两个栈,应为第二个栈没有弹出操作，并且需要顺序输出，所以直接用链表
        Stack<String> s1=new Stack<>();
        List<String> s2=new ArrayList<>();

        for(String item:ls){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//弹出"("
            }else{
                while(s1.size()!=0&&(Operation.getValue(item)<=Operation.getValue(s1.peek()))){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    static class Operation{
        private static int ADD=1;
        private static int SUB=1;
        private static int MUL=2;
        private static int DIV=2;

        public static int getValue(String operation){
            int res=0;
            switch(operation){
                case "+":
                    res=ADD;
                    break;
                case "-":
                    res=SUB;
                    break;
                case"x":
                    res=MUL;
                    break;
                case"/":
                    res=DIV;
                default:
                    System.out.println("operation do not exist");
                    break;
            }
            return res;
        }

    }
    public static int cal(List<String> ls){
        Stack<String> stack=new Stack<>();

        for(String item:ls){
            //使用正则表达式,匹配是否为数字
            if(item.matches("\\d+")){
                stack.push(item);
            }else{
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num2-num1;
                }else if(item.equals("x")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num2/num1;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
