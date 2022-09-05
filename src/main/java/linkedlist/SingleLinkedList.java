package linkedlist;

public class SingleLinkedList {

    //先初始化一个头节点，不要动
    private Node head=new Node(0,"");

    public Node getHead() {
        return head;
    }

    //添加节点到单向链表
    //1.找到最后节点
    //2.将最后这个节点的next 指向新节点
    public void add(Node node)
    {
        Node temp=head;
        while (temp.next != null) {
            //    System.out.println(temp);
            temp = temp.next;
        }
        temp.next=node;
    }
    //按照编号顺序添加节点
    public void addByOrder(Node node)
    {
        Node temp=head;
        boolean flag=false; //标识添加编号是否存在
        while (true)
        {
            if(temp.next==null)
                break;
            if(temp.next.no>node.no) //在temp后面添加
                break;
            else if(temp.next.no==node.no) //添加的node编号已经存在
            {
                flag=true;
                break;
            }
            temp=temp.next; //遍历当前列表
        }
        if(flag)
        {
            System.out.println("Cannot add "+temp.no+ ", it has existed");
        }
        else
        {
            node.next=temp.next;
            temp.next=node;
        }
    }

    //按照编号来修改节点；
    public void update(Node newNode)
    {
        if(head.next==null)
        {
            System.out.println("List is empty");
            return;
        }
        Node temp=head.next;
        boolean flag=false;
        while (true)
        {
            if(temp==null)
                break;
            if(temp.no==newNode.no)
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag)
            temp.Name=newNode.Name;
        else
            System.out.println("Can not find node "+newNode.no);
    }

    //删除节点
    public void remove(int no)
    {
        Node temp=head;
        boolean flag=false;
        while (true){
            if(temp.next==null)
                break;
            if(temp.next.no==no) {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }
        else
            System.out.println("Can not find node "+no+" .");
    }
    public void list()
    {
        //判断链表为空
        if(head.next==null)
        {
            System.out.println("LinkedList is empty");
            return;
        }
        //因为头节点不能动，所以需要一个辅助变量来遍历
        Node temp=head.next;
        while(temp!=null)
        {
            System.out.println(temp);
            temp=temp.next;
        }
    }

    //面试题1
    public int count()
    {
        Node temp=head.next;
        int count=0;
        while (temp!=null){
           count++;
           temp=temp.next;
        }
        return count;
    }
}
