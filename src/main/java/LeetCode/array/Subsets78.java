package LeetCode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        int n=nums.length;
        for(int i=(int)Math.pow(2,n);i<(int)Math.pow(2,n+1);i++){
            String bitMask=Integer.toBinaryString(i).substring(1);
            List<Integer> list=new LinkedList<>();
            for(int j=0;j<n;j++){
                if(bitMask.charAt(j)=='1')list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> cascade(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newLists =new ArrayList<>();
            for(List<Integer> cur:lists){
                newLists.add(new ArrayList<Integer>(cur){
                    {add(num);}//匿名子类的构造器
                });
            }
            lists.addAll(newLists);
        }
        return lists;
    }

    int space;
    int n;
    List<List<Integer>> output=new ArrayList<>();
    public List<List<Integer>> backtrackingSubset(int[] nums){
        n=nums.length;
        for(space=0;space<=n;space++){
            backtracking(0,new ArrayList<>(),nums);
        }
        return output;
    }
    private void backtracking(int first,List<Integer> cur,int[] nums){
        if(cur.size()==space){
            output.add(new ArrayList<>(cur));
            return;
        }
        for(int i=first;i<n;i++){
            cur.add(nums[i]);
            backtracking(i+1,cur,nums);
            cur.remove(cur.size()-1);
        }
    }


}
