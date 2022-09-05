package stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        Node head=new Node(0);
        int maxSize=4;
        LinkedListStack lls=new LinkedListStack(head,maxSize);
        for(int i=1;i<maxSize;i++){
            Node n=new Node(i);
            lls.push(n);
        }
        lls.list();
        System.out.println();
        System.out.println(lls.pop().getNo());
        System.out.println(lls.pop().getNo());
        System.out.println();
        lls.list();
    }
}

class LinkedListStack{
    private Node head;
    private Node pre;
    private int top=-1;
    private int maxSize;
    public LinkedListStack(Node head,int maxSize){
        this.head=head;
        this.pre=this.head;
        this.maxSize=maxSize;
        top++;
    }
    public boolean isEmpty(){
        return top<0;
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    public void push(Node n){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        n.setPre(this.pre);
        this.pre=n;
        top++;
    }
    public Node pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        Node temp=this.pre;
        pre=pre.getPre();
        top--;
        return temp;
    }

    public void list(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        Node temp=pre;
        for(int i=top;i>=0;i--){
            System.out.println(temp.getNo());
            temp=temp.getPre();
        }
    }
}

class Node{
    private int no;
    private Node pre;

    public Node(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

}