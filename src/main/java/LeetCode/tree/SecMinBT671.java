package LeetCode.tree;

public class SecMinBT671 {
    int min;
    long secMin=Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        min=root.val;
        DFS(root);
        return secMin<Long.MAX_VALUE ? (int) secMin :-1;
    }
    public void DFS(TreeNode root) {
        if (root!=null){
            if(min<root.val&&root.val<secMin){
                secMin=root.val;
            }else if(min==root.val){
                DFS(root.left);
                DFS(root.right);
            }
        }
        
    }
}
