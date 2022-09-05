package LeetCode.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int sum=0;
        int move=0;
        int v1=0;
        int v2=0;
        while (l1!=null||l2!=null){
            if(l1!=null) {
                v1 = l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                v2=l2.val;
                l2=l2.next;
            }
            sum=v1+v2+move;
            if(sum>=10){
                move=1;
                sum=sum%10;
            }else move=0;
            node.next=new ListNode(sum);
            node=node.next;
            v1=v2=0;
        }
        if(move==1)node.next=new ListNode(1);
        return dummy.next;
    }
}
