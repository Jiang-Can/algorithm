package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;

public class DeepestLeavesSum1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null)return 0;
        int maxHeight=getMaxHeight(root);
        List<TreeNode> nodes=new LinkedList<>();
        List<TreeNode> lastNodes=new LinkedList<>();
        lastNodes.add(root);
        int height=1;
        while (height<maxHeight){
            nodes.clear();
            for(TreeNode node:lastNodes){
                if(node.left!=null){
                    nodes.add(node.left);
                }
                if(node.right!=null){
                    nodes.add(node.right);
                }

            }
            lastNodes.clear();
            lastNodes.addAll(nodes);
            height++;
        }
        int sum=0;
        for(TreeNode node:nodes){
            sum+=node.val;
        }
        return sum;
    }
    private int getMaxHeight(TreeNode root){
        return  Math.max(root.left==null?0:getMaxHeight(root.left), root.right==null?0:getMaxHeight(root.right))+1;
    }

    //my second solution
    int sum=0;
    int curHeight=0;
    int maxHeight=0;
    public int deepestLeavesSum2(TreeNode root) {
        calculateSum(root);
        return sum;
    }
    private void calculateSum(TreeNode root){
        if(root==null)return;
        curHeight++;
        if(curHeight==maxHeight){
            sum+=root.val;
        }else if(curHeight>maxHeight){
            sum=0;
            maxHeight=curHeight;
            sum+=root.val;
        }
        calculateSum(root.right);
        calculateSum(root.left);
        curHeight--;
    }
}
