package linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleNode n1=new DoubleNode(1,"aa");
        DoubleNode n3=new DoubleNode(3,"cc");
        DoubleNode n5=new DoubleNode(5,"ee");
        DoubleNode n8=new DoubleNode(8,"ii");
        DoubleNode n4=new DoubleNode(4,"dd");

        DoubleLinkedList dl=new DoubleLinkedList();
        dl.add(n1);
        dl.add(n3);
        dl.add(n5);
        dl.list();
        System.out.println();

        dl.addByOrder(n4);
        dl.addByOrder(n8);
        dl.list();
    }
}

