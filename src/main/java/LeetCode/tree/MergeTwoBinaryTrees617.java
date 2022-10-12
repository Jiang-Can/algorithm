package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees617 {

    //recursive way
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        }
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    // iterative way BFS
    public TreeNode mergeTreesIter(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root1, root2});
        while (!queue.isEmpty()) {
            TreeNode[] cur = queue.poll();
            if(cur[1] == null) {
                continue;
            }
            cur[0].val += cur[1].val;

            if(cur[0].left != null) {
                queue.add(new TreeNode[]{cur[0].left, cur[1].left});
            } else {
                cur[0].left = cur[1].left;
            }

            if(cur[0].right != null) {
                queue.add(new TreeNode[]{cur[0].right, cur[1].right});
            } else {
                cur[0].right = cur[1].right;
            }
        }
        return root1;
    }

}
