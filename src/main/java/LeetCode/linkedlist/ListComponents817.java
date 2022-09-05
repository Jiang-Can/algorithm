package LeetCode.linkedlist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ListComponents817 {

}

class Solution817 {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set=new HashSet<>();
        for(int element:G){
            set.add(element);
        }
        int count=0;
        List<Integer> subset=new LinkedList<>();
        while (head!=null){
            if(set.contains(head.val)){
                subset.add(head.val);
            }else{
                if(subset.size()>0){
                    count++;
                    subset.clear();
                }
            }
            head=head.next;
        }
        if (subset.size()>0){
            count++;
        }
        return count;
    }

    public int numComponents2(ListNode head, int[] G) {
        HashSet<Integer> set=new HashSet<>();
        for(int element:G){
            set.add(element);
        }
        int count=0;
        while (head!=null){
            if(set.contains(head.val)&&
                    (head.next==null ||!set.contains(head.next.val))){      // next is not in set or is null
                count++;
            }
            head=head.next;
        }
        return count;
    }
}
