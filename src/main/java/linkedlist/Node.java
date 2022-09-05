package linkedlist;

public class Node {
    public int no;
    public String Name;
    public Node next; //指向下一个节点

    public Node(int no,String Name)
    {
        this.no=no;
        this.Name=Name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", Name='" + Name + '\'' +
                '}';
    }

}
