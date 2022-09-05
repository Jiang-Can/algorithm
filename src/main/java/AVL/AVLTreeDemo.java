package AVL;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr={4,3,6,5,7,8};
        int[] arr={10,12,8,9,7,6};

        AVLTree avlTree=new AVLTree();
        for(int value:arr){
            avlTree.add(new Node(value));
        }
        avlTree.show();
        System.out.println("height:"+avlTree.root.height());
        System.out.println("left height:"+avlTree.root.leftHeight());
        System.out.println("right height:"+avlTree.root.rightHeight());
        System.out.println("root:"+avlTree.root);
    }

}
class AVLTree{
    Node root;
    public void add(Node node){
        if(root==null){
            this.root=node;
        }else{
            root.add(node);
        }
    }
    public void show(){
        if(root==null){
            System.out.println("Empty tree");
        }else{
            root.infixOrder();
        }
    }
}
class Node {
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value=value;
    }
    public void add(Node node){
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else{
                this.left.add(node);
            }
        }else{
            if(this.right==null){
                this.right=node;
            }else{
                this.right.add(node);
            }
        }
        if(rightHeight()-leftHeight()>1){
            if(this.right!=null&&this.right.leftHeight()>right.rightHeight()){
                this.right.leftRotate();
            }
            leftRotate();
        }else if(leftHeight()-rightHeight()>1){
            if(this.left!=null&&this.left.rightHeight()>left.leftHeight()){
                this.left.leftRotate();
            }
            rightRotate();
        }
    }

    private void leftRotate(){
        Node newNode=new Node(value);
        newNode.left=this.left;
        newNode.right=this.right.left;
        this.value=this.right.value;
        this.right=this.right.right;
        this.left=newNode;
    }
    private void rightRotate(){
        Node newNode=new Node(value);
        newNode.right=this.right;
        newNode.left=this.left.right;
        this.value=this.left.value;
        this.left=this.left.left;
        this.right=newNode;

    }
    //左子数高度
    public int leftHeight(){
        if(this.left==null){
            return 0;
        }else{
            return left.height();
        }
    }
    //右子树高度
    public int rightHeight(){
        if(this.right==null){
            return 0;
        }else{
            return right.height();
        }
    }

    public int height(){
        return Math.max(this.left==null? 0:this.left.height(),this.right==null? 0:this.right.height())+1;
    }
    //查找节点
    public Node searchTarget(int value){
        if(this.value==value){
            return this;
        }
        if(value<this.value){
            if(this.left!=null){
                return this.left.searchTarget(value);
            }else{
                return null;
            }
        }else {
            if(this.right!=null){
                return this.right.searchTarget(value);
            }else{
                return null;
            }
        }
    }
    //查找父节点
    public Node searchParent(int value){
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value))
            return this;
        if(value<this.value&&this.left!=null){
            return this.left.searchParent(value);
        }else if(value>=this.value&&this.right!=null){
            return this.right.searchParent(value);
        }else{
            return null;
        }
    }
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}