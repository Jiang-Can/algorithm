package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {

    public static void main(String[] args) {
        UniqueBinarySearchTreesII95 uniqueBinarySearchTreesII95 = new UniqueBinarySearchTreesII95();
        uniqueBinarySearchTreesII95.generateTrees(3);
    }
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> dp = new ArrayList<>();
        if(n == 0)return null;
        dp.add(new ArrayList<>());
        dp.get(0).add(null);
        dp.add(new ArrayList<>());
        dp.get(1).add(new TreeNode(1));
        if(n == 1) return dp.get(1);
        for(int i = 2; i <= n; i++){
            List<TreeNode> dpValue = new ArrayList<>();
            for(int j = 0; j<i; j++) {
                //left
                for(TreeNode leftNode: dp.get(j)){
                    TreeNode newNode = new TreeNode(j+1);
                    newNode.left = leftNode;
                    // right
                    for(TreeNode rightNode: dp.get(i-j-1)) {
                        newNode.right = imitateConstruct(rightNode,j+1);
                        dpValue.add(newNode);
                        newNode = cloneNodeWithLeft(newNode);
                    }
                }
            }
            dp.add(dpValue);
        }
        return dp.get(n);
    }

    private TreeNode imitateConstruct(TreeNode node, int add) {
        if(node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.val + add);
        newNode.left = imitateConstruct(node.left, add);
        newNode.right = imitateConstruct(node.right, add);
        return newNode;
    }

    private TreeNode cloneNodeWithLeft(TreeNode node) {
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = node.left;
        return newNode;
    }
}
