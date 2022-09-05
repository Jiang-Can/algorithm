package linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node n1=new Node(1,"aa");
        Node n3=new Node(3,"cc");
        Node n5=new Node(5,"ee");
        Node n8=new Node(8,"ii");
        Node n4=new Node(4,"dd");
        Node newNode=new Node(3,"ccc");

        SingleLinkedList sl=new SingleLinkedList();
        sl.add(n1);
        sl.add(n3);
        sl.add(n8);
        sl.list();
        System.out.println();
        sl.addByOrder(n5);
        sl.addByOrder(n4);
        sl.list();
        System.out.println();
        sl.update(newNode);
        sl.list();
        System.out.println();
        sl.remove(3);
        sl.list();

        //面试题

        //1. 求单链表中有效节点的个数(不带头节点)
        System.out.println(sl.count());
        //2. 得到倒数第k个节点
        System.out.println(reversCount(sl,3));

        System.out.println();
        //3. 反转单向链表
        System.out.println("reverst list");
        reversList(sl.getHead());
        sl.list();

        System.out.println();
        //4. 反向打印链表
        reversePrint(sl.getHead());

        //合并连个链表
        Node n2=new Node(2,"bb");
        Node n6=new Node(6,"ff");
        Node n7=new Node(7,"gg");
        SingleLinkedList sl2=new SingleLinkedList();
        sl2.add(n2);
        sl2.add(n6);
        sl2.add(n7);
    }
    //2. 得到倒数第k个节点
    public static Node reversCount(SingleLinkedList ls,int k){
        if(k>ls.count()||k<=0)
            return null;
        else{
            int num=ls.count()-k;
            Node temp=ls.getHead().next;
            for(int i=0;i<num;i++){
                temp=temp.next;
            }
            return temp;
        }
    }
    //3. 反转单向链表
    public static void reversList(Node head){
        if((head.next==null)||(head.next.next==null)){ //空和单个元素链表都不需要反转
            return;
        }
        Node reversHead=new Node(0,"");
        Node cur=head.next;
        Node next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=reversHead.next;
            reversHead.next=cur;
            cur=next;
        }
    head.next=reversHead.next;
    }

    //4
    public static void reversePrint(Node head){
        Node cur=head.next;
        Stack<Node> stack=new Stack<>();
        if(cur==null){
            System.out.println("list is empty");
            return;
        }
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while(stack.size()>0)
            System.out.println(stack.pop());
    }
}

