package LeetCode.tree;

import java.util.*;

public class BinaryTreePostorderTraversal145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.addFirst(cur.val);

            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null) {
                stack.push(cur.right);
            }

        }
        return (List) res;
    }
}
