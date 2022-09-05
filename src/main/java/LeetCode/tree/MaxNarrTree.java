package LeetCode.tree;


import java.util.List;

public class MaxNarrTree {
    public int maxDepth(Node root) {
        if (root==null){
            return 0;
        }
        if(root.children==null){
            return 1;
        }
        int max=0;
        int temp;
        for(Node child:root.children){
            temp= maxDepth(child);
            if(temp>max){
                max=temp;
            }
        }
        return max+1;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}