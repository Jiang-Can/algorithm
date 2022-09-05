package LeetCode.array.stack;


import java.util.Stack;

public class DecodeString394 {
    //stack method
    public String decodeStringStack(String s) {
        Stack<Integer> times=new Stack<>();
        Stack<StringBuilder> strs=new Stack<>();
        StringBuilder cur=new StringBuilder();
        int t=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                t=t*10+ch-'0';
            }else if(ch=='['){
                times.push(t);
                strs.push(cur);
                cur=new StringBuilder();
                t=0;
            }else if(ch==']'){
                String repeat=cur.toString();
                cur=strs.pop();
                for(int i=times.pop();i>0;i--){
                    cur.append(repeat);
                }
            }else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }




    //recursion method
    int i=0;
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        while (i<s.length()){
            res.append(buildString(s));
        }
        return res.toString();
    }
    private StringBuilder buildString(String s){
        StringBuilder timesStr=new StringBuilder();
        StringBuilder retStr=new StringBuilder();
        while (isNumber(s.charAt(i))){
            timesStr.append(s.charAt(i++));
        }
        int times=timesStr.length()==0?1:Integer.parseInt(timesStr.toString());
        if(s.charAt(i)=='['){
            ++i;
            while (s.charAt(i)!=']'){
                if(isNumber(s.charAt(i))){
                    retStr.append(buildString(s));
                }else {
                    retStr.append(s.charAt(i++));
                }
            }
            ++i;
            //multiply times for str
            String repeatedStr=retStr.toString();
            for(int j=1;j<times;j++){
                retStr.append(repeatedStr);
            }
        }else {
            while (i<s.length()&&!isNumber(s.charAt(i))){
                retStr.append(s.charAt(i++));
            }
        }
        return retStr;
    }
    private boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }
}
