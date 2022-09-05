package LeetCode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class LongestConsecutiveSequence128 {

    public int longestConsecutive1(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int res=0,i,count;
        for(int num:set){
            if(!set.contains(num-1)){
                i=num+1;count=1;
                while (set.contains(i)){
                    count++;
                    i++;
                }
                res=Math.max(res,count);
            }
        }
        return res;
    }




    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        int i,count=1;
        for (int num : nums) {
            if(!map.containsKey(num)){
                i=1;
                if(map.containsKey(num+1)&&map.containsKey(num-1)){
                    map.put(num, count=map.get(num-1)+map.get(num+1)+1);
                    while (map.containsKey(num+i)){
                        map.put(num+i++,count);
                    }
                    i=1;
                    while (map.containsKey(num-i)){
                        map.put(num-i++,count);
                    }
                }
                if(map.containsKey(num+1)){ //smallest number in the consequent seq
                    map.put(num, count=map.get(num+1)+1);
                    while (map.containsKey(num+i)){
                        map.put(num+i++,count);
                    }
                }else if(map.containsKey(num-1)){ //largest number in the consequent seq
                    map.put(num,count=map.get(num-1)+1);
                    while (map.containsKey(num-i)){
                        map.put(num-i++,count);
                    }
                }else {map.put(num,1);}
                res=Math.max(res,count);
            }
        }
        return res;
    }

}
/*
class Node{
    int val;
    int count;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}*/
