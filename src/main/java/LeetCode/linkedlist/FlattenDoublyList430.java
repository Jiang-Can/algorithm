package LeetCode.linkedlist;


public class FlattenDoublyList430 {
    public Node flatten(Node head) {
        process(head);
        return head;
    }
    public void process(Node head){
        if(head==null)return;
        if(head.child!=null){
            Node temp=head.next;
            process(head.child);    //这里顺序要注意
            Node subTail=getTail(head.child);    //这里不能颠倒
            head.next=head.child;
            head.next.prev=head;
            if(temp!=null){
                temp.prev=subTail;
            }
            subTail.next=temp;
            head=subTail;
        }
        process(head.next);
    }
    public Node getTail(Node head){
        if(head==null) return null;
        while (head.next!=null) {
            head=head.next;
        }
        return head;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
