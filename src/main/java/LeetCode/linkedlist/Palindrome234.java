package LeetCode.linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Palindrome234 {
    
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        Stack<ListNode> stack=new Stack<>();
        while(fast!=null&&fast.next!=null){
            stack.push(slow);
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            stack.push(slow);
        }
        while (!stack.isEmpty()){
            if(stack.pop().val!=slow.val){
                return false;
            }
            slow=slow.next;
        }
        return true;
    }
}
// iterative
class Solution206Reverse{
    public ListNode reverseList(ListNode head) {
         ListNode pre=null;
         ListNode cur=head;
         while (cur!=null){
               ListNode temp=cur.next;
               cur.next=pre;
               pre=cur;
               cur=temp;
         }
         return pre;
    }
}
//recursive
class Solution206Reverse2{
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
        
    }
}

class SolutionRemoveAll203{
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null&&head.val==val){
            head=head.next;
        }
        ListNode h=head;
        ListNode node=head;
        while (node!=null){
            if(node.next!=null&&node.next.val==val){
                while(node.next!=null&&node.next.val==val){
                    node=node.next;
                }
                h.next=node.next;
            } else{
                h=h.next;
                node=h;
            }
        }
        return head;
    }
}

// singly linked list circle checking
// good method for checking circle
class SolutionLinkedCycled141Two{
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
// My solution
class SolutionLinkedLCycled141{
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head=head.next;
        }
        return false;
    }
}