package Algorithms.dynamicprogramming;

import java.util.ArrayList;

public class DynamicProgramming {
    public static void main(String[] args) {
        DynamicProgramming dp=new DynamicProgramming();
        dp.addTask(new Task(1,4,5));
        dp.addTask(new Task(3,5,1));
        dp.addTask(new Task(0,6,8));
        dp.addTask(new Task(4,7,4));
        dp.addTask(new Task(3,8,6));
        dp.addTask(new Task(5,9,3));
        dp.addTask(new Task(6,10,2));
        dp.addTask(new Task(8,11,4));
        dp.generatePreOpt();
        System.out.println(dp.OPT(8));
    }
    private ArrayList<Task> taskList;
    private ArrayList<Integer> preOpt;
    public DynamicProgramming(){
        taskList=new ArrayList<>();
        taskList.add(null);
        preOpt=new ArrayList<>();
        preOpt.add(null);
    }

    private void addTask(Task task){
        taskList.add(task);
    }
    public int OPT(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return taskList.get(1).benefit;
        }else{
            return Math.max(OPT(n-1),(OPT(preOpt.get(n))+taskList.get(n).benefit));
        }

    }
    private void generatePreOpt(){
        for(int i=1;i<taskList.size();i++){
            preOpt.add(getPreOpt(i));
        }
    }
    private int getPreOpt(int n){
        if (n != 0) {
            for (int i = n - 1; i >= 1; i--) {
                if (taskList.get(i).end <= taskList.get(n).start) {
                    return i;
                }
            }
        }
        return 0;
    }


}
