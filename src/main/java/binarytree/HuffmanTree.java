package binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        HNode root=creatHuffmanTree(arr);
        root.preOrder();
    }
    public static HNode creatHuffmanTree(int[] arr){
        ArrayList<HNode> hNodes= new ArrayList<>();
        for(int value:arr){
            hNodes.add(new HNode(value));

        }
        while(hNodes.size()>1){
            Collections.sort(hNodes);
            HNode leftNode= hNodes.get(0);
            HNode rightNode= hNodes.get(1);
            HNode parent=new HNode(leftNode.value+rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;
            hNodes.remove(leftNode);
            hNodes.remove(rightNode);
            hNodes.add(parent);
        }
        return hNodes.get(0);
    }

}

class HNode implements Comparable<HNode>{
    int value;
    HNode left;
    HNode right;


    public HNode(int value){
        this.value=value;
    }
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    public String toString(){
        return "Node: "+value;
    }

    @Override
    public int compareTo(HNode o) {
        //从小到大
        return this.value-o.value;
    }
}