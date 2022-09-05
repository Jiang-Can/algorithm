package LeetCode.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode node=head;
        HashSet<Integer> set=new HashSet<>();
        set.add(node.val);
        ListNode temp;
        while (node!=null){
            temp=node;
            while (node.next!=null&&set.contains(node.next.val)){
                node=node.next;
            }
            temp.next=node.next;
            if(node.next!=null) set.add(node.next.val);
            node= temp.next;
        }
        return head;
    }
}
