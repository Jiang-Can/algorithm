package LeetCode.linkedlist;

public class RemoveDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-999999);
        dummy.next=head;
        ListNode node=dummy;
        ListNode ndNode;
        while (node!=null){
            ndNode=findNotDuplicatedNode(node);
            node.next=ndNode;
            node=node.next;
        }
        return dummy.next;
    }
    public ListNode findNotDuplicatedNode(ListNode head) {
        if(head==null) return null;
        while (head.next != null && (head.val == head.next.val)) {
            head = head.next;
        }
        head = head.next;
        if (head == null || head.next == null||
        head.val!=head.next.val) return head;
        return findNotDuplicatedNode(head);
    }

    public ListNode delete(ListNode head){
        ListNode cur=head;
        ListNode next=head;
        ListNode prev=new ListNode(-1);
        prev.next=head;
        ListNode node=prev;
        int count=0;
        while (next!=null){
            count=0;
            while (next!=null&&cur.val==next.val){
                next=next.next;
                count++;
            }
            if(count>1){
                prev.next=next;
            } else{
                prev=cur;
            }
            cur=next;
        }

        return node.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode current = head;
        ListNode next = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode node = prev;
        int count;
        while(next != null) {
            count = 0;
            while(next != null && current.val == next.val) {
                next = next.next;
                count++;
            }

            if (count > 1) {
                prev.next = next;
            } else {
                prev = current;
            }
            current = next;
        }

        return node.next;
    }
}
