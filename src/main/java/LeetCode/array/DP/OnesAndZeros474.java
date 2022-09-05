package LeetCode.array.DP;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OnesAndZeros474 {

    public int findMaxForm(String[] strs, int m, int n) {
        return 1;
    }

    public static void main(String[] args) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(1,Arrays.asList(11,12,13));
        map.put(2,Arrays.asList(21,22));
        map.put(3, List.of(31));
        map.put(4,Arrays.asList(41,42,43,44));

        boolean flag = false;

        int target = 7;
        ArrayList<Integer> integers = new ArrayList<>(map.keySet());
        Collections.shuffle(integers);
        List<List<Integer>> dp = new ArrayList<>(target+1);
        dp.addAll(Collections.nCopies(target+1,null));
        dp.set(0,new ArrayList<>());
        for(Integer questionId: integers) {
            int cap = map.get(questionId).size();

            for(int i = target; i>=cap ; i--) {
                if(dp.get(i-cap) == null || dp.get(i)!=null) {
                    continue;
                }
                List<Integer> temp = new ArrayList<>(dp.get(i-cap));
                temp.addAll(map.get(questionId));
                if(i == target){
                    flag = true;
                    System.out.println(temp);
                    break;
                }
                dp.set(i,temp);
            }
            if(flag) break;
        }
    }
}

class Test {
    Integer i;
    public Test(int i) {
        this.i = i;
    }
}
