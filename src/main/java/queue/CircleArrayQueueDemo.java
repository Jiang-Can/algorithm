package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue carrq=new CircleArrayQueue(4);
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
                carrq.addData(value);
            }
            else if(key=='g')
            {
                try{
                    System.out.println(carrq.getData());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(key=='s')
            {
                carrq.show();
            }
            else if(key=='q')
            {
                loop=false;
                scan.close();
            }
            else if((key!='a')&&(key!='g')&&(key!='s')&&(key!='q'))
            {
                System.out.println("wrong input");
            }
        }
    }
}
class CircleArrayQueue
{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr; //该数据用于存放数据，模拟队列

    public CircleArrayQueue(int maxSize)
    {
        this.maxSize=maxSize; //起始位置为0，就需要多预留一个空间进行操作
        arr=new int[maxSize];
        front=0; //指向队列头
        rear=0;  //指向队列尾
    }
    public boolean isFull()
    {
        return (rear+1)%maxSize==front;
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
        {
            arr[rear]=data;
            rear=(rear+1)%maxSize;
        }
    }
    public int getData()
    {
        if(isEmpty())  //需要返回值的方法必须要返回值或者返回值
            throw new RuntimeException("Queue is" +
                    " empty");
        else
            {
                int value=arr[front];
                front=(front+1)%maxSize;
                return value;
            }
    }
    //显示队列的所有数据
    public void show()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
        }
            //可用数据为(rear+maxSize-front)%maxSize
        for(int i=front;i<front+(rear+maxSize-front)%maxSize;i++)
        {
            System.out.print(arr[i%maxSize]+" ");
        }
        System.out.println();
    }
}
