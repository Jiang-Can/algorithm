package LeetCode.linkedlist;

public class RemoveFromEndOnePass19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode h=dummy;
        ListNode t=dummy;
        for(int i=0;i<n;i++){
            t=t.next;
        }
        while (t.next!=null){
            h=h.next;
            t=t.next;
        }
        h.next=h.next.next;
        return dummy.next;
    }
}
