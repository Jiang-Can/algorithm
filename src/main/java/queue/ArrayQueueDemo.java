package queue;

        import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrq=new ArrayQueue(3);
        char key=' ';
        Scanner scan=new Scanner(System.in);
        boolean loop= true;
        while(loop)
        {
            System.out.println("option：");
            key=scan.next().charAt(0);
            if(key=='a')
            {
                int value=scan.nextInt();
                arrq.addData(value);
            }
            else if(key=='g')
            {
                try{
                    System.out.println(arrq.getData());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(key=='s')
            {
                arrq.show();
            }
            else if(key=='q')
            {
                loop=false;
                scan.close();
            }
        }
    }
}

//数组模拟编写一个ArrayQueue类
class ArrayQueue
{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr; //该数据用于存放数据，模拟队列

    public ArrayQueue(int maxSize)
    {
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1; //指向队列头
        rear=-1;  //指向队列尾
    }
    public boolean isFull()
    {
        return rear==maxSize-1;
    }
    public boolean isEmpty()
    {
        return front==rear;
    }
    public void addData(int data)
    {
        if(isFull())
            System.out.println("Queue is full");
        else
            arr[++rear]=data;

    }
    public int getData()
    {
        if(isEmpty())  //需要返回值的方法必须要返回值或者返回值
            throw new RuntimeException("Queue is" +
                    " empty");
        else
            return arr[++front];
    }
    //显示队列的所有数据
    public void show()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
        }
        for(int i=0;i<=rear;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
