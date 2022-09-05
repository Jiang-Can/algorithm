package BST;

public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr={7,3,10,12,5,1,9,2};
        BinarySearchTree bst=new BinarySearchTree();
        for(int value:arr){
            bst.addNode(new Node(value));
        }

        bst.delNode(7);
        bst.infixPrint();
    }
}
// 生成BST
class BinarySearchTree{
    Node root;
    public void addNode(Node node){
        if(root==null){
            this.root=node;
        }else{
            this.root.add(node);
        }
    }
    public void infixPrint(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("Empty binary tree");
        }
    }
    public Node searchNode(int value){
        if(this.root==null){
            return null;
        }else{
            return root.searchTarget(value);
        }
    }
    public Node searchParent(int value){
        if(this.root==null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }
    //找到右子数最小
    public int delRightMin(Node node){
        Node temp=node;
        while(temp.left!=null){
            temp=temp.left;
        }
        delNode(temp.value);
        return temp.value;
    }

    public void delNode(int value){
        if(root==null){
            return;
        }
        //找到节点
        Node target=searchNode(value);
        if(target==null){
            return;
        }
        //如果是只有根节点
        if(root.left==null&&root.right==null){
            root=null;
        }
        Node parent=searchParent(value);
        //两个子树都为空时不需要考虑parent的情况，应为单个root会在之前步骤被删除
        if(target.left==null&&target.right==null){
            if(parent.left==target){
                parent.left=null;
            }else{
                parent.right=null;
            }
        }else if(target.left!=null&&target.right!=null){
            target.value= delRightMin(target.right);
        }//单个子树时需要考虑target为root parent为空的情况
        else if(target.left!=null){
            if(parent!=null){
                if(target==parent.left){
                    parent.left=target.left;
                }else if(target==parent.right) {
                    parent.right = target.left;
                }
            }else{
                this.root=target.left;
            }

        }else {
            if(parent!=null){
                if(target==parent.left){
                    parent.left=target.right;
                }else if(target==parent.right){
                    parent.right=target.right;
                }
            }else{
                this.root=target.right;
            }

        }
    }
}

//删除BST


class Node{
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