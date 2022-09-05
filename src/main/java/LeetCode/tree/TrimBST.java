package LeetCode.tree;

public class TrimBST {


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)return root;
        if(root.val>high)return trimBST(root.left,low,high);
        if(root.val<low)return trimBST(root.right,low,high);
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }


    //linked list method
    public TreeNode trimBST2(TreeNode root, int low, int high){
        if(root==null) return null;
        while (root!=null&&(root.val<low||root.val>high)){
            if(root.val<low){
                root=root.right;
            }
            if(root.val>high){
                root=root.left;
            }
        }
        TreeNode dummy=root;
        while (dummy!=null){
            TreeNode cur=dummy.left;
            while (cur!=null&&cur.val<low){
                if(cur.right!=null){
                    cur=cur.right;
                }else{
                    cur= null;
                }
            }
            dummy.left=cur;
            dummy=dummy.left;
        }
        dummy=root;
        while (dummy!=null){
            TreeNode cur=dummy.right;
            while (cur!=null&&cur.val>high){
                if(cur.left!=null){
                    cur=cur.left;
                }else{
                    cur= null;
                }
            }
            dummy.right=cur;
            dummy=dummy.right;
        }
        return root;
    }
}
