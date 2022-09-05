package LeetCode.hashtable;

import java.util.*;

public class GroupAnagramsAlgo {
    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        Map<String,List<String>> res = new HashMap<>();
        char[] temp;
        String sortedStr;
        for(String word:words){
            temp = word.toCharArray();
            Arrays.sort(temp);
            sortedStr = Arrays.toString(temp);
            if(res.containsKey(sortedStr)){
                res.get(sortedStr).add(word);
            }else {
                res.put(sortedStr,new ArrayList<>(List.of(word)));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:res.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
