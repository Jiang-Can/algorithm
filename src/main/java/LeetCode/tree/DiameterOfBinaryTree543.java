package LeetCode.tree;

public class DiameterOfBinaryTree543 {
    private int path = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        postTraverse(root);
        return path;
    }

    private int postTraverse(TreeNode node) {
        if(node == null){
            return 0;
        }
        int left = postTraverse(node.left);
        int right = postTraverse(node.right);
        path = Math.max(path,left+right);
        return Math.max(left,right)+1;
    }
}
