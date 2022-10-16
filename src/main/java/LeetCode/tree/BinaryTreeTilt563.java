package LeetCode.tree;

public class BinaryTreeTilt563 {

    private int res = 0;
    public int findTilt(TreeNode root) {
        nodesSum(root);
        return res;
    }

    private int nodesSum(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = nodesSum(node.left);
        int right = nodesSum(node.right);
        res += Math.abs(left - right);
        return left + right + node.val;
    }

}