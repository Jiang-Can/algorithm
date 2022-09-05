package binarytree;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String love="i love love love li xi min";
        huffmanZip(love);
    }
    //huffman 压缩
    private static void huffmanZip(String origin){
        byte[] bytes=origin.getBytes();
        HCNode node=buildHuffmanCode(bytes).get(0);
        //node.preOrder();
        getCodes(stringCode,"",node);
        /*for (Map.Entry<Byte, String> byteStringEntry : huffmanCode.entrySet()) {
            System.out.println(byteStringEntry);
        }
        System.out.println("After zip:");*/
        System.out.println(Arrays.toString(zip(bytes)));
    }
    //存储字符与其对应的huffman 编码
    static Map<Byte,String> huffmanCode=new HashMap<>();

    static StringBuilder stringCode=new StringBuilder();

    private static byte[] zip(byte[] bytes){
        //存储原始字符串转换成huffman编码的二进制字符串
        StringBuilder huffmanStr=new StringBuilder();
        for(byte b:bytes){
            huffmanStr.append(huffmanCode.get(b));
        }
        System.out.println(huffmanStr);
        int num=(huffmanStr.length()+7)/8;
        //byte存储的都是补码
        byte[] zipBytes=new byte[num];

        for(int i=0;i<num;i++){
            String str;
            if(i<num-1){
                str=huffmanStr.substring(i*8,(i+1)*8);
            }else{
                str=huffmanStr.substring(i*8);
            }
            zipBytes[i]= (byte) Integer.parseInt(str,2);
        }
        return zipBytes;
    }

    //获得一个 huffman 编码的map
    private static void getCodes(StringBuilder stringCode,String code,HCNode node){
        StringBuilder stringCode2=new StringBuilder(stringCode);
        stringCode2.append(code);
        if (node != null) {
            if(node.data==0){
                //像左递归
                getCodes(stringCode2,"0",node.left);
                //向右递归
                getCodes(stringCode2,"1",node.right);
            }else{
                //需要把stringBuilder 转化成string
                huffmanCode.put(node.data,stringCode2.toString());
            }
        }
    }

    //用byte串构建huffman code
    private static List<HCNode> buildHuffmanCode(byte[] bytes){
        ArrayList<HCNode> nodes=new ArrayList<>();






        Map<Byte,Integer> byteMap=new HashMap<>();

        for(byte b: bytes){
            Integer count=byteMap.get(b);
            if(count==null){
                byteMap.put(b,1);
            }else{
                byteMap.put(b,count+1);
            }
        }
        for(Map.Entry<Byte,Integer> m:byteMap.entrySet()){
            HCNode node=new HCNode(m.getKey(),m.getValue());
            nodes.add(node);
        }
        while (nodes.size()>1){
            Collections.sort(nodes);
            HCNode leftNode=nodes.get(0);
            HCNode rightNode=nodes.get(1);
            HCNode parent=new HCNode(nodes.get(0).weight+nodes.get(1).weight);
            parent.left=leftNode;
            parent.right=rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes;
    }
}

class HCNode implements Comparable<HCNode> {
    byte data;
    int weight;
    HCNode left;
    HCNode right;

    public HCNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }
    public HCNode(int weight) {
        this.weight = weight;
    }
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "HCNode{" +
                "data=" +(char) data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HCNode o) {
        return this.weight - o.weight;
    }
}