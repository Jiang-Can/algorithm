package LeetCode.tree;



public class ConvertToBT {
    //108
    //best solution for constructing a balanced tree with a sorted array
    public TreeNode BestSolution108(int[] nums) {
        if(nums.length==0)return null;
        return constructAVLTree(nums,0,nums.length-1);
    }
    private TreeNode constructAVLTree(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(end+start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=constructAVLTree(nums, start, mid-1);
        root.right=constructAVLTree(nums, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        ConvertToBT c=new ConvertToBT();
        System.out.println(c.BestSolution108(nums));
    }


    //traditional solution ( can solve the array which is not sorted)
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length<1) {
            return null;
        }
        TreeNode root= new TreeNode(nums[0]);
        for(int i=1;i<nums.length;i++){
            addNode(nums[i],root);
        }
        return root;
    }
    public void addNode(int num,TreeNode root) {
        if (num < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(num);
            } else {
                addNode(num, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(num);
            } else {
                addNode(num, root.right);
            }
        }
        //left heavy
        if(height(root.left)-height(root.right)>1){
            if(height(root.left.right)>height(root.left.left)){
                leftRotate(root.left);
            }
            rightRotate(root);
        }
        //right heavy
        if(height(root.right)-height(root.left)>1){
            if(height(root.right.left)>height(root.right.right)){
                rightRotate(root.right);
            }
            leftRotate(root);
        }
    }

    public void leftRotate(TreeNode root){
        TreeNode newNode=new TreeNode(root.val);
        newNode.right=root.right.left;
        newNode.left=root.left;
        root.val=root.right.val;
        root.right=root.right.right;
        root.left=newNode;
    }

    public void rightRotate(TreeNode root){
        TreeNode newNode=new TreeNode(root.val);
        newNode.left=root.left.right;
        newNode.right=root.right;
        root.val=root.left.val;
        root.left=root.left.left;
        root.right=newNode;
    }

    public int height(TreeNode root){
        if(root==null)return 0;
        return Math.max(root.left==null?0:height(root.left), root.right==null?0:height(root.right))+1;
    }
}
