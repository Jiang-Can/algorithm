package LeetCode.tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> cur = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if( root == null) {
            return res;
        }
        res.add(List.of(root.val));
        cur.add(root);
        while (!cur.isEmpty()) {
            List<TreeNode> next = new LinkedList<>();
            List<Integer> tempRes = new LinkedList<>();
            for(TreeNode node: cur) {
                if(node.left != null) {
                    next.add(node.left);
                    tempRes.add(node.left.val);
                }
                if(node.right != null) {
                    next.add(node.right);
                    tempRes.add(node.right.val);
                }
            }
            if(next.isEmpty()){
                break;
            }
            cur.clear();
            cur.addAll(next);
            res.add(tempRes);
        }
        return res;
    }


}
