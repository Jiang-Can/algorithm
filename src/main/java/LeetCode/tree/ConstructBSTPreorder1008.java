package LeetCode.tree;

//************* best solution
public class ConstructBSTPreorder1008 {
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] preorder,int bound){
       if(i==preorder.length||preorder[i]>bound) return null;
       TreeNode node=new TreeNode(preorder[i++]);
       //left node should be less than this node
       node.left=construct(preorder, node.val);

       //right node should be less than this node's parent val
       node.right=construct(preorder,bound);
       return node;
    }

}
