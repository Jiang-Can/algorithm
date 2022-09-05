package LeetCode.tree;

import java.util.HashSet;
import java.util.Set;

public class FindElements1261 {
    Set<Integer> set=new HashSet<>();
    public FindElements1261(TreeNode root) {
        recover(root,0);
    }

    private void recover(TreeNode root,int rightVal){
        if(root==null) return;
        root.val=rightVal;
        set.add(rightVal);
        recover(root.left, rightVal*2+1);
        recover(root.right, rightVal*2+2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
