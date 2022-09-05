package LeetCode.linkedlist;

public class MyLinkedList707 {
    ListNode head;
    ListNode tail;
    int size=0;
    /** Initialize your data structure here. */
    public MyLinkedList707() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index>=size){
            System.out.println("out of bound");
            return 0;
        }
        ListNode node=head;
        int count=0;
        while (node!=null){
            if(count==index){
                return node.val;
            }
            count++;
            node=node.next;
        }
        return 0;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead=new ListNode(val);
        if (head != null) {
            newHead.next = head;
        }
        head=newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node=new ListNode(val);
        if(head==null){
            head=node;
            tail=head;
        } else{
            tail.next=node;
            tail=tail.next;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size){
            System.out.println("out of bound");
            return;
        }
        if(index==size){
            this.addAtTail(val);
        }
        if (index==0){
            this.addAtHead(val);
        }
        int count=1;
        ListNode node=head;
        ListNode temp;
        while (node.next!=null){
            if(count==index){
                temp=node.next;
                node.next=new ListNode(val);
                node.next.next=temp;
                size++;
                break;
            }
            node=node.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode temp;
        if(index>=size){
            System.out.println("out of bound");
            return;
        }
        if(index==0){
            head=head.next;
        }
        ListNode node=head;
        int count=1;
        while (node!=null){
            if(index==count){
                node.next=node.next.next;
                size--;
                break;
            }
            node=node.next;
            count++;
        }
    }
}
