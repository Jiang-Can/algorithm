package LeetCode.linkedlist;

import java.util.Stack;

public class ReorderList143 {
    public static void main(String[] args) {
        int[] input={1,2,3,4,5};
        LinkedList ll=new LinkedList(input);
        Solution143 sol=new Solution143();
        ListNode head=ll.head;
        sol.reorderList(head);
        System.out.println(head);
    }
}
class Solution143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        //find the node before the middle node
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse and divide the second half part
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        //interweave 2 lists
        ListNode temp1,temp2;
        while (fast!=null){
            temp1 = slow.next;
            temp2 = fast.next;
            slow.next = fast;

            fast.next = temp1;
            slow = temp1;
            fast = temp2;
        }


    }
    private ListNode reverse(ListNode node){
        ListNode cur = node;
        ListNode pre = null;
        ListNode temp;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}