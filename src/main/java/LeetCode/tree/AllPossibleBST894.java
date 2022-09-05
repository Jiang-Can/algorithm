package LeetCode.tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleBST894 {
    Map<Integer,List<TreeNode>> cache=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res=new LinkedList<>();
        if(N==1){
            res.add(new TreeNode(0));
            return res;
        }
        if(N%2==0)return res;
        if(cache.containsKey(N)){
            return cache.get(N);
        }
        N--;
        for(int i=1;i<N;i+=2){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(N-i);
            for(TreeNode leftNode:left){
                for(TreeNode rightNode:right){
                    TreeNode root=new TreeNode(0);
                    root.left=leftNode;
                    root.right=rightNode;
                    res.add(root);
                }
            }
            cache.put(N+1,res);
        }
        return res;
    }

}
