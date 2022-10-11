package LeetCode.tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree101 {

    // recursive
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if((left == null ^ right == null) ||
                (left.val != right.val)) {
            return false;
        }
        return check(left.left, right.right) &&
                check(left.right, right.left);
    }

    // iterative
    public boolean isSymmetricIter(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> qL = new LinkedList<>();
        Queue<TreeNode> qR = new LinkedList<>();
        qL.add(root.left);
        qR.add(root.right);
        while(!qL.isEmpty() && !qR.isEmpty()) {
            TreeNode tempL = qL.poll();
            TreeNode tempR = qR.poll();
            if(tempL == null && tempR == null) {
                continue;
            }
            if((tempL == null ^ tempR == null)||
                    (tempL.val != tempR.val) ) {
                return false;
            }

            qL.add(tempL.left);
            qL.add(tempL.right);
            qR.add(tempR.right);
            qR.add(tempR.left);

        }

        return qL.isEmpty() && qR.isEmpty();
    }





    public boolean isSymmetric2(TreeNode root) {
         return isMirror(root, root);
    }
    public boolean isMirror(TreeNode l,TreeNode r){
        if(l==null&&r==null){
            return true;
        }
        if(l==null||r==null){
            return false;
        }
        return (l.val==r.val)
                &&isMirror(l.left, r.right)
                &&isMirror(l.right,r.left);
    }

    // Same tree  100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return (p.val==q.val)
                &&isSameTree(p.left,q.left)
                &&isSameTree(p.right,q.right);
    }
}
