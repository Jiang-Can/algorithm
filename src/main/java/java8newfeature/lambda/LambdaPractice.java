package java8newfeature.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class LambdaPractice {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"new thread");
            }
        };
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(r1);
        t1.start();

        Runnable r2 = ()->{System.out.println(Thread.currentThread().getName()+"new thread");};
        Thread t2 = new Thread(r2);
        t2.start();

        //Consumer 类型
        Consumer<String> cos = str -> {
            System.out.println(str);
        };

        //Function类型
        Comparator<Integer> comparator = (a1,a2)->{ return Integer.compare(a1,a2);};
        Comparator<Integer> comparator1 = (a1,a2)-> Integer.compare(a1,a2);
        Comparator<Integer> comparator2 = Integer::compare;

        CustomFuncInterface customFuncInterface = (a1)->{
                int sum =0;
                for (int a : a1) {
                    sum+=a;
                }
                return sum;
            };
        int add = customFuncInterface.add(1, 2, 3);
        System.out.println(add);

        int outSum = 10;

        //Lambda 内不能使用外部变量，
/*        CustomFuncInterface customFuncInterface1 = (a1)->{
            for(int a:a1){
                outSum += outSum+a;
            }
            return outSum;
        };*/


    }
}
