package LeetCode.tree;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.Collectors;

public class LowestCommonAncestorBT236 {

/*    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    }*/

    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>(Arrays.asList(1,1,2,3,3,3,4,4,4,4));

        Set<Integer> collect = new HashSet<>(integers);

        System.out.println(integers.size());

        System.out.println(collect.size());

    }

}