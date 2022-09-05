package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        TreeNode temp,cur;
        while (!bfs.isEmpty()){
            cur = bfs.poll();
            temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left != null){
                bfs.add(cur.left);
            }
            if(cur.right != null){
                bfs.add(cur.right);
            }
        }
        return  root;
    }
}
