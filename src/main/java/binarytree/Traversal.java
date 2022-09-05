package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.right = new BST(22);

        System.out.println(Traversal.postOrderTraverse(root,new ArrayList<>()));
    }
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        Stack<BST> stack = new Stack<>();
        stack.push(tree);
        BST temp;
        while (!stack.isEmpty()){
            temp = stack.pop();
            if(temp!=null){
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                stack.push(temp);
                stack.push(null);
                if(temp.left!=null){
                    stack.push(temp.left);
                }
            }else {
                array.add(stack.pop().value);
            }
        }
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        Stack<BST> stack = new Stack<>();
        stack.push(tree);
        BST temp;
        while (!stack.isEmpty()){
            temp = stack.pop();
            array.add(temp.value);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }

        }
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        Stack<BST> stack = new Stack<>();
        stack.push(tree);
        BST temp;
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp!=null){
                stack.push(temp);
                stack.push(null);
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                if(temp.left!=null){
                    stack.push(temp.left);
                }
            }else {
                array.add(stack.pop().value);
            }
        }
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
