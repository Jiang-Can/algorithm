package LeetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        CombinationSum39 c=new CombinationSum39();
        int[] ca=new int[]{2,3,6,7};
        c.combinationSum(ca,7);
    }
    int n=-1;
    int sum=0;
    int target;
    int[] nums;
    List<List<Integer>> output=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        //great than target can be abandoned
        for(int i=0;i<candidates.length;i++){
            if(candidates[i]>target){
                n=i;break;
            }
        }

        if(n==-1)n=candidates.length;

        this.target=target;this.nums=candidates;
        backtracking(0, new ArrayList<>());
        return output;
    }

    private boolean backtracking(int first,List<Integer> cur){
        if(sum==target){
            output.add(new ArrayList<>(cur));
            return false;
        }
        if(sum>target)return false;
        boolean flag; //如果返回的是true说明向下递归backtracking的一轮全部找完都没要找到或者没要超过target,所有继续找下一轮.
                      //但是如果返回的是true,则没有必要继续本轮查找直接跳出
        for(int i=first;i<n;i++){
            sum+=nums[i];
            cur.add(nums[i]);
            flag=backtracking(i, cur);
            sum-=nums[i];
            cur.remove(cur.size()-1);
            if(!flag)break;
        }
        return true;
    }
}
