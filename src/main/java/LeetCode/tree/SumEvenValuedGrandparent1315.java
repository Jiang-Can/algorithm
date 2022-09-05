package LeetCode.tree;

public class SumEvenValuedGrandparent1315 {
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.val%2==0){
            return getSum(root)+
                    sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
        }else{
            return sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
        }
    }
    private int getSum(TreeNode root){
        int sum=0;
        if(root.left!=null){
            if(root.left.left!=null){
                sum+=root.left.left.val;
            }
            if(root.left.right!=null){
                sum+=root.left.right.val;
            }
        }
        if(root.right!=null){
            if(root.right.left!=null){
                sum+=root.right.left.val;
            }
            if(root.right.right!=null){
                sum+=root.right.right.val;
            }
        }
        return sum;
    }
}
