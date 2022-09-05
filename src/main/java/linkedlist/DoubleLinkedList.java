package linkedlist;

public class DoubleLinkedList {
    private DoubleNode head=new DoubleNode(0,"");

    public DoubleNode getHead() {
        return head;
    }

    public void add(DoubleNode node)
    {
        DoubleNode temp=head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next=node;
        node.pre=temp;
    }

    public void addByOrder(DoubleNode node){
        DoubleNode temp=head.next;
        boolean flag=false;
        while(true){
            if(temp.next==null)
                break;
            if(temp.next.no>node.no)
                break;
            if(temp.next.no==node.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag)
            System.out.println("Node "+node.no+" has existed");
        else {
            node.pre = temp;
            node.next = temp.next;
            if (temp.next != null)
                temp.next.pre = node;
            temp.next = node;
        }
    }
    //删除节点
    public void remove(int no)
    {
        DoubleNode temp=head.next;
        boolean flag=false;
        while (true){
            if(temp==null)
                break;
            if(temp.no==no) {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.pre.next=temp.next;

            //这里代码有问题，如果temp是最后一个节点，temp.next就是null
            //null指向前一个会出现空指针异常，所以要添加if
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }
        else
            System.out.println("Cannot find node "+no+" .");
    }

    //按照编号来修改节点；
    public void update(DoubleNode newNode)
    {
        if(head.next==null)
        {
            System.out.println("List is empty");
            return;
        }
        DoubleNode temp=head.next;
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
            System.out.println("Cannot find node "+newNode.no);
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
        DoubleNode temp=head.next;
        while(temp!=null)
        {
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
