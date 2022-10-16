package LeetCode.tree;

import java.util.Stack;

public class RangeSumBST938 {
    // recursive way
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        if(root.val >= low && root.val <= high) {
            return root.val
                    + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
        if(root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        // root.val > high
        return rangeSumBST(root.left, low, high);
    }

    // iterative preorder
    public int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);

        while (!stack.isEmpty()) {
            cur = stack.pop();
            if(cur == null) {
                continue;
            }
            if(cur.val >= low && cur.val <= high) {
                sum += cur.val;
                stack.push(cur.right);
                stack.push(cur.left);
            }
            if(cur.val < low) {
                stack.push(cur.right);
            }
            if(cur.val > high) {
                stack.push(cur.left);
            }
        }
        return sum;
    }

    // iterative inorder
    public int rangeSumBST3(TreeNode root, int low, int high) {
        int sum = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.val >= low && cur.val <= high) {
                sum += cur.val;
            }
            if(cur.val > high) {
                break;
            }
            cur = cur.right;
        }
        return sum;
    }
}
