package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedBinaryTree110 {


    public boolean isBalanced(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int rec = -1;
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if((cur.left == null && cur.right == null) ||
                        (cur.left == null ^ cur.right == null)) {
                    if(rec == -1) {
                        rec = 0;
                    }
                }
                if(cur.left != null) {
                    temp.add(cur.left);
                }
                if(cur.right != null) {
                    temp.add(cur.right);
                }
            }

            if(rec != -1) {
                if(++rec > 1) {
                    return  false;
                }
            }
            queue.addAll(temp);
        }

        return true;
    }

}
