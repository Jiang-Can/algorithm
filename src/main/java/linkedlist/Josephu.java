package linkedlist;


public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList csl=new CircleSingleLinkedList();
        csl.addBoy(5);
        csl.show();
        System.out.println();
        csl.countBoy(1,2,5);
    }
}
//创建一个环形单向链表
class CircleSingleLinkedList{
    private Boy first;
    public void addBoy(int num){
        if(num<1){
            System.out.println("num must greater than 1");
            return;
        }

        Boy temp=null;
        for(int i=1;i<=num;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                temp=first;
            }else{
                temp.setNext(boy);
                temp=boy;
                boy.setNext(first);
            }
        }
    }

    //小孩出圈
    //StartNo 第几个小孩开始数
    //countNum 表示数几下
    //num 圈里有几个小孩
    public void  countBoy(int startNo,int countNum,int num){
        if(first==null||startNo>num||startNo<1){
            System.out.println("parameter error");
            return;
        }
        Boy helper=first;
        for(int i=1;i<startNo;i++){
            first=first.getNext();
        }
        //让helper是first的前一个节点
        while(helper.getNext()!=first)
            helper=helper.getNext();

        while (helper != first) {
            for (int i = 1; i < countNum; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("no " + first.getNo() + " is out");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("last no is "+ first.getNo());

    }
    public void show(){
        Boy temp=first;
        if(first==null)
            System.out.println("no boy");
        do{
            System.out.println("no "+temp.getNo());
            temp=temp.getNext();
        }while(temp!=first);
    }
}

//表示节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no=no;
    }
    public int getNo() {
        return no;
    }
    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}