package LeetCode.linkedlist;

public class RemoveNthNodeFromEndOfList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1), slow = start, fast = head;
        start.next = head;
        for(int i = 0; i < n; i ++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        ListNode b = a;
        a = a.next;
        System.out.println(a);
        System.out.println(b);
    }
}
