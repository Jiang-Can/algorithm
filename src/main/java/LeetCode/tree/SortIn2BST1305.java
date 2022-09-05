package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;

public class SortIn2BST1305 {
    List<Integer> list1=new LinkedList<>();
    List<Integer> list2=new LinkedList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res=new LinkedList<>();
        if(root1!=null){
            constructList(root1,list1);
        }
        if(root2!=null){
            constructList(root2,list2);
        }

        int i1=0;
        int i2=0;

        if(root1!=null&&root2!=null){
            while (i1<list1.size()&&i2<list2.size()){
                if(list1.get(i1)<list2.get(i2)){
                    res.add(list1.get(i1++));
                }else{
                    res.add(list2.get(i2++));
                }
            }
        }
        for(int i=i1;i<list1.size();i++) {
            res.add(list1.get(i1));
        }
        for(int i=i2;i<list2.size();i++){
            res.add(list2.get(i1));
        }

        return res;
    }
   private void constructList(TreeNode root,List<Integer> list){
        if(root.left!=null){
            constructList(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            constructList(root.right,list);
        }
   }

    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        System.out.println(list.size());
    }
}
