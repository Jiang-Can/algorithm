package LeetCode.linkedlist;

public class MiddleOfLinkedList876 {
    
}

// answer
class Solution3{
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

}
//My answer
/*
class Solution3 {
    public ListNode middleNode(ListNode head) {
        int count=0;
        ListNode node=head;
        while (node!=null){
            count++;
            node=node.next;
        }
        for(int i=0;i<count/2;i++){
            head=head.next;
        }
        return head;
    }
}*/
