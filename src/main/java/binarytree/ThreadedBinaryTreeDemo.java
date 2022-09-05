package binarytree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node n2=new Node(3);
        Node n3=new Node(6);
        Node n4=new Node(8);
        Node n5=new Node(10);
        Node n6=new Node(14);
        /*
        *          1
        *      3      6
        *    8 10   14
        * */
        ThreadedBinaryTree threadTree=new ThreadedBinaryTree(root);
        root.setLeft(n2);
        root.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);

        //测试线索化
        threadTree.threadedNodes(root);
        System.out.println(n5.getLeft()+" "+n5.getRight());
        threadTree.threadedList();
    }
}


class ThreadedBinaryTree{
    private Node root;
    private Node pre=null;
    public ThreadedBinaryTree(Node root){
        this.root=root;
    }
    //node 就是当前需要线索化的节点
    public void threadedNodes(Node node){
        if(node==null){
            return;
        }
        threadedNodes(node.getLeft());
        //处理当前节点的前驱节点
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理pre节点的后继节点
        if(pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;

        threadedNodes(node.getRight());
    }
    //遍历线索化二叉树的方法
    public void threadedList(){
        Node node=root;
        while(node!=null){
            while(node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while(node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }


    }
}
class Node{
    private int no;
    private Node left;
    private Node right;
    private int leftType;
    private int rightType;
    // leftType=0 指向左子树  =1指向前驱结点
    // rightType=0 指向右子数 =1指向后继节点


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node(int no){
        this.no=no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "no = "+this.no;
    }
}