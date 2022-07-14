package d220713.q102;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    static void helper(TreeNode node, List<List<Integer>> result, int depth){
        if (node == null) return;
        if (depth == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        helper(node.left, result, depth+1);
        helper(node.right, result, depth+1);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
