package LeetCode.array.string;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstring {

    public static void main(String[] args) {
        System.out.println(underscorifySubstring("abababababababababababababaababaaabbababaa", "a"));

    }

    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        List<int[]> records = new ArrayList<>();
        for(int i = 0;i<=str.length()-substring.length();i++){
            if(str.charAt(i) == substring.charAt(0)){
                findSubString(str,substring,i,records);
            }
        }
        collapseList(records);
        return generateResult(records,str);
    }

    private static void findSubString(String str, String substring, int start, List<int[]> records){
        int i = 0; // sub
        int j = start; // main
        while (j<str.length()&&i<substring.length()){
            if(str.charAt(j) == substring.charAt(i)){
                if(i == substring.length()-1){
                    records.add(new int[]{start,j});
                }
            }else{
                break;
            }
            i++;
            j++;
        }
    }

    private static void collapseList(List<int[]> records){
        if(records.size()<2)return;
        int next;
        int i = 0;
        while (i< records.size()-1){
            next = records.get(i+1)[0];
            if(records.get(i)[1]>=next-1){
                records.get(i)[1] = records.get(i+1)[1];
                records.remove(i+1);
            }else{
                i++;
            }
        }
    }

    private static String generateResult(List<int[]> records, String str){
        boolean enter = false;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i<str.length();i++){
            if(index == records.size()){
                sb.append(str.substring(i));
                break;
            }
            if(enter){
                sb.append(str.charAt(i));
                if(i == records.get(index)[1]){
                    sb.append('_');
                    index++;
                    enter = false;
                }
            }else{
                if(i == records.get(index)[0]){
                    sb.append('_');
                    enter = true;
                }
                sb.append(str.charAt(i));

                //handle problem when substring's length is 1
                if(i == records.get(index)[0]&&records.get(index)[0]==records.get(index)[1]){
                    sb.append('_');
                    enter = false;
                    index++;
                }
            }
        }
        return sb.toString();
    }
}
