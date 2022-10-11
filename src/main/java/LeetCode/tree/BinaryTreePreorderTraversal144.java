package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        stack.push(root);
        TreeNode cur;
        while(!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }
}
