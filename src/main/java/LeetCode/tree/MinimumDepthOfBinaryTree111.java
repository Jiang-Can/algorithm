package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class MinimumDepthOfBinaryTree111 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if((root.left == null) ^ (root.right == null)) {
            return minDepth(Objects.requireNonNullElseGet(root.left, () -> root.right)) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    //iterative way

    public int minDepthIter(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 1;
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null) {
                    return height;
                }
                if(cur.left != null) {
                    temp.add(cur.left);
                }
                if(cur.right != null) {
                    temp.add(cur.right);
                }
            }
            queue.addAll(temp);
            ++ height;
        }
        return -1;
    }
}
