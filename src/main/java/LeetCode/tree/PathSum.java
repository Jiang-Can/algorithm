package LeetCode.tree;



import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSum {
    LinkedList<Integer> sums=new LinkedList<>();
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        nodeSum(root,0);
        for(int val:sums){
            if(val==sum){
                return true;
            }
        }
        return false;
    }
    public void nodeSum(TreeNode root,int nodeSum){
        nodeSum+=root.val;
        if(root.left!=null){
            nodeSum(root.left,nodeSum);
        }
        if(root.right!=null){
            nodeSum(root.right,nodeSum);
        }
        if(root.left==null&&root.right==null){
            sums.add(nodeSum);
        }
    }
    //simple way
    public boolean hasPathSumSimple(TreeNode root, int sum){
          if(root==null){
              return false;
          }
          if(root.left==null&&root.right==null&&root.val==sum){
              return true;
          }
          return hasPathSumSimple(root.left,sum-root.val)||hasPathSumSimple(root.right,sum-root.val);
    }

    // Step 2: return list
    List<List<Integer>> pathList=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path=new LinkedList<>();
        pathRecorder(root,sum,path);
        return pathList;
    }
    public void pathRecorder(TreeNode root,int sum,List<Integer> path){
        if(root==null){
            return;
        }
        List<Integer> list = new LinkedList<>(path);  // this path need to be cloned, since it is an address, it will
                                                      // use the same list
        list.add(root.val);
        if(root.right==null&&root.left==null&&root.val==sum){
            pathList.add(list);
        }
        pathRecorder(root.left,sum-root.val,list);
        pathRecorder(root.right,sum-root.val,list);
    }
    // my method 2

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        Stack<Integer> path=new Stack<>();
        pathStack(root,sum,path);
        return pathList;
    }
    public void pathStack(TreeNode root,int sum,Stack<Integer> path){
        if(root==null){
            return;
        }
        path.push(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){
            Stack<Integer> stack=new Stack<>();
            stack.addAll(path);
            pathList.add(stack);
        }
        pathStack(root.left,sum-root.val,path);
        pathStack(root.right,sum-root.val,path);
        path.pop();
    }
}
