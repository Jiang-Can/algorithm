package LeetCode.tree;

import java.util.Stack;

public class MinimumAbsoluteDifferenceBST530 {

    private int minDiff = Integer.MAX_VALUE;
    private int curVal = -1;
    public int getMinimumDifference(TreeNode root) {
        findMinDiff(root);
        return minDiff;
    }
    // recursive
    private void findMinDiff(TreeNode root) {
        if(root == null) {
            return;
        }
        findMinDiff(root.left);
        if(curVal != -1) {
            minDiff = Math.min(minDiff, Math.abs(root.val - curVal));
        }
        curVal = root.val;
        findMinDiff(root.right);
    }

    private int findMinDiff2(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        TreeNode cur = root;
        int lastVal = -1;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()) {

            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(lastVal != -1 ) {
                minDiff = Math.min(minDiff, Math.abs(cur.val - lastVal));
            }
            lastVal = cur.val;
            cur = cur.right;
        }
        return minDiff;
    }


}
