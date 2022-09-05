package Algorithms.Dpbag;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bag {
    public static void main(String[] args) {
        Bag bag=new Bag(4);
        bag.addItem(new Item("Guitar",1,1500));
        bag.addItem(new Item("Speaker",4,3000));
        bag.addItem(new Item("Laptop",3,2000));
        System.out.println(bag.Opt());
        bag.showMap();
    }
    private int capacity;
    private int[][] table;
    private ArrayList<Item> items;
    private HashMap<Integer, String> values;

    public Bag(int capacity){
        this.capacity=capacity;
        items=new ArrayList<>();
        values=new HashMap<>();
    }
    private void addItem(Item item){
        items.add(item);
    }
    private void showMap(){
        for(Map.Entry<Integer,String> entry:values.entrySet()){
            System.out.println("Value:"+entry.getKey()+" Item(s):"+entry.getValue());
        }
    }
    public String Opt(){
        this.table=new int[items.size()+1][capacity+1];
        for(int item=1;item<table.length;item++){
            for(int weight=1;weight<table[0].length;weight++){
                if(items.get(item-1).weight>weight){
                    table[item][weight]=table[item-1][weight];
                }else {
                    int former=table[item-1][weight-items.get(item-1).weight];
                    int choice=former+items.get(item-1).value;
                    int notChoice=table[item-1][weight];
                    int max;
                    if(choice>notChoice){
                        if(values.containsKey(former)){
                            values.put(choice,values.get(former)+" "+items.get(item-1).name);
                        }else{
                            values.put(choice,items.get(item-1).name);
                        }
                        max=choice;
                    }else{
                        max=notChoice;
                    }
                    table[item][weight]=max;
                }
            }
        }
        return table[items.size()][capacity]+" "+values.get(table[items.size()][capacity]);
    }
}
