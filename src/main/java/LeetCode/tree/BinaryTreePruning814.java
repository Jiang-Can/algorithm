package LeetCode.tree;

public class BinaryTreePruning814 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(0);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(1);
        BinaryTreePruning814 b=new BinaryTreePruning814();
        b.pruneTree(root);
    }
    public TreeNode pruneTree(TreeNode root) {
        return prune(root)?null:root;
    }
    private boolean prune(TreeNode root){
        if(root==null)return true;
        boolean l=prune(root.left);
        boolean r=prune(root.right);
        if(l)root.left=null;
        if(r)root.right=null;
        return root.val == 0 && l && r;
    }
}
