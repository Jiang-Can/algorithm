package LeetCode.linkedlist;


public class ReverseList92 {
    public static void main(String[] args) {
        LinkedList ls=new LinkedList(new int[]{3,5});
        ReverseList92 r=new ReverseList92();
        r.reverseBetween(ls.head,1,2);
        System.out.println(r);
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n==1||head==null||head.next==null||m==n){
            return head;
        }
        int point=1;
        ListNode node=head;
        ListNode startPrev;
        ListNode start=head;
        ListNode temp;
        ListNode pre=null;
        if(m>1) {
            while (point < m - 1) {
                node = node.next;
                point++;
            }
            startPrev = node;
            start = startPrev.next;
            node = node.next;
            point = m;
            while (point<=n){
                temp=node.next;
                node.next=pre;
                pre=node;
                node=temp;
                point++;
            }
            startPrev.next=pre;
            start.next=node;
            return head;
        } else{
            while (point<=n){
                temp=node.next;
                node.next=pre;
                pre=node;
                node=temp;
                point++;
            }
        }
        start.next=node;
        return pre;
    }

}
