package LeetCode.linkedlist;

public class SortList148 {

}
class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left,right);
        
    }
    static ListNode merge(ListNode left,ListNode right){
        ListNode start=new ListNode();
        ListNode nullStart=start;
        while (left!=null&&right!=null){
            if(left.val<=right.val){
                nullStart.next=left;
                nullStart=nullStart.next;
                left=left.next;
            }else{
                nullStart.next=right;
                nullStart=nullStart.next;
                right=right.next;
            }
        }









        nullStart.next=(left!=null)? left:right;
        return start.next;
    }
    static ListNode getMid(ListNode head){
        ListNode preMid=null;
        while (head!=null&&head.next!=null){
            preMid=(preMid==null) ? head:preMid.next;
            head=head.next.next;
        }
        ListNode mid=preMid.next;
        preMid.next=null;
        return mid;
    }
}

