package LeetCode.tree;

public class CountCompleteTreeNodes222 {
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
