package LeetCode.linkedlist;

public class ConvertBinToDeci1290 {
    public static void main(String[] args) {
         int[] input={1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
         LinkedList ll=new LinkedList(input);
         Solution sol=new Solution();
        System.out.println(sol.getDecimalValue(ll.head));
    }
}


class LinkedList{
    ListNode head;
    int[] binArr;
    int length;
    public LinkedList(int[] binArr) {
        this.binArr = binArr;
        head=new ListNode(binArr[0]);
        length=binArr.length;
        constructList(binArr,head);
    }

    public void constructList(int[] binArr,ListNode head){
        ListNode node=head;
        for(int i=1;i<length;i++){
            node.addNode(new ListNode(binArr[i]));
            node=node.next;
        }
    }
}

// answer
class Solution {
    public int getDecimalValue(ListNode head) {
        int sum=0;
        while (head!=null){
            sum*=2;
            sum+=head.val;
            head=head.next;
        }
        return sum;
    }
}
//
class Solution2{
    public int getDecimalValue(ListNode head) {
        int num=head.val;
        while (head.next!=null){
            num=(num<<1) | head.next.val;
            head=head.next;
        }
        return num;
    }
}
/*//my solution
class Solution {
    public int getDecimalValue(int[] input) {
        LinkedList ll=new LinkedList(input);
        int len=ll.length-1;
        int sum=0;
        ListNode node=ll.head;
        while (node!=null) {
            if(node.val!=0){
                sum+=Math.pow(2,len);
            }
            len--;
            node=node.next;
        }
        return sum;
    }
}*/
//  Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      public void addNode(ListNode node){
          this.next=node;
      }

/*    @Override
    public String toString() {
        return "val " + val +
                " next " + next+" ";
    }*/
}
