package LeetCode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            Stack<Node> stack = new Stack<>();

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
