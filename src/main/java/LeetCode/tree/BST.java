package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BST {
    //700
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        if(root.val>val){
            return searchBST(root.left,val);
        }
        return searchBST(root.right,val);
    }

    //701
    public TreeNode insertIntoBST(TreeNode root, int val) {
        newNode=new TreeNode(val);
        if(root==null){
            root=newNode;
            return root;
        }else{
            insert(root,val);
        }
        if(flag){
            TreeNode dummy=root;
            while (dummy.right!=null){
                dummy=dummy.right;
            }
            dummy.right=newNode;
        }
        return root;
    }
    TreeNode newNode;
    boolean flag=true;   //check if new node has been add
    public void insert(TreeNode root,int val) {
        if(root==null){
            return;
        }
        insert(root.left,val);
        if(flag&&root.val>val){
            newNode.left=root.left;
            root.left=newNode;
            flag=false;
        }
        insert(root.right,val);
    }

    //provided best solution ********
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left= insertIntoBST2(root.left,val);
        }
        if(val>root.val){
            root.right=insertIntoBST2(root.right,val);
        }
        return root;
    }

    //257 BST path
    Stack<String> paths=new Stack<>();
    List<String> output=new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return output;
        buildPath(root);
        return output;
    }
    private void buildPath(TreeNode root){
        paths.add(root.val+"");
        if(root.left==null&&root.right==null){
            StringBuilder str=new StringBuilder();
            str.append(paths.get(0));
            for(int i=1;i<paths.size();i++){
                str.append("->").append(paths.get(i));
            }
            output.add(str.toString());
            paths.pop();
            return;
        }
        if(root.left!=null) buildPath(root.left);
        if(root.right!=null) buildPath(root.right);
        paths.pop();
    }

    //938. Range Sum of BST

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)return 0;
        if(root.val>=low&&root.val<=high){
            return root.val+
                    rangeSumBST(root.right, low, high)+
                    rangeSumBST(root.left, low, high);
        }
        if(root.val<low) return rangeSumBST(root.right,low,high);

        //when root.val>high
        return rangeSumBST(root.left,low,high);
    }



    //617. Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)return t2;
        if(t2==null) return t1;
        t1.val+=t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right, t2.right);
        return t1;
    }
}
