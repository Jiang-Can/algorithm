package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;

public class NaryOrderTraversal {
    List<Integer> l=new LinkedList<>();
    public List<Integer> preorder(Node root) {
        List<Integer> list=new LinkedList<>();
        if(root==null){
            return null;
        }
        list.add(root.val);
        if(root.children==null){
            return list;
        }
        for(Node child:root.children){
            if(child.children!=null){
                list.addAll(preorder(child));
            }
        }
        return list;
    }
    public  List<Integer> solution(Node root){
        if(root==null){
            return l;
        }
        preRecur(root);
        return l;
    }
    public void preRecur(Node root){
        l.add(root.val);
        if(root.children!=null){
            for(Node child:root.children){
                preRecur(child);
            }
        }
    }
    public void postRecur(Node root){
        if(root.children!=null){
            for(Node child:root.children){
                preRecur(child);
            }
        }
        l.add(root.val);
    }
}
