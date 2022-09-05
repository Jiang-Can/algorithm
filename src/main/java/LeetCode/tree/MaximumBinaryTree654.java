package LeetCode.tree;

public class MaximumBinaryTree654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0,nums.length-1);
    }
    private TreeNode construct(int[] nums,int start,int end){
        if(start>end)return null;
        int maxPosition=findMaxPosition(nums,start,end);
        TreeNode root=new TreeNode(nums[maxPosition]);

        root.left=construct(nums,maxPosition+1, end);
        root.right=construct(nums,start,maxPosition-1);

        return root;
    }
    private int findMaxPosition(int[] nums,int start,int end){
        int position=start;
        int max = nums[start];
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                max=nums[i];
                position=i;
            }
        }
        return position;
    }
}
