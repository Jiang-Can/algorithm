package linkedlist;

public class DoubleNode {
    public int no;
    public String Name;
    public DoubleNode next; //指向下一个节点
    public DoubleNode pre; //指向前一个节点

    public DoubleNode(int no,String Name)
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
