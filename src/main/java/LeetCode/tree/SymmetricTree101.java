package LeetCode.tree;


import java.util.LinkedList;
import java.util.List;

public class SymmetricTree101 {

    // my solution
    List<Integer> left=new LinkedList<>();
    List<Integer> right=new LinkedList<>();
    public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
        if(root.left==null||root.right==null){
            return false;
        }
        leftTraverse(root.left);
        rightTraverse(root.right);
        if(left.size()!=right.size()) return false;
        boolean flag=true;
        for(int i=0;i<left.size();i++){
            if(!left.get(i).equals(right.get(i))){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public void leftTraverse(TreeNode root){
        left.add(root.val);
        if(root.left!=null){
            leftTraverse(root.left);
        }else{
            left.add(-1);
        }
        if(root.right!=null){
            leftTraverse(root.right);
        }else {
            left.add(-1);
        }
    }
    public void rightTraverse(TreeNode root){
        right.add(root.val);
        if(root.right!=null){
            rightTraverse(root.right);
        }else{
            right.add(-1);
        }
        if(root.left!=null){
            rightTraverse(root.left);
        }else{
            right.add(-1);
        }
    }

    // Best solution
    public boolean isSymmetric2(TreeNode root) {
         return isMirror(root, root);
    }
    public boolean isMirror(TreeNode l,TreeNode r){
        if(l==null&&r==null){
            return true;
        }
        if(l==null||r==null){
            return false;
        }
        return (l.val==r.val)
                &&isMirror(l.left, r.right)
                &&isMirror(l.right,r.left);
    }

    // Same tree  100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return (p.val==q.val)
                &&isSameTree(p.left,q.left)
                &&isSameTree(p.right,q.right);
    }
}
