package d220711.q199;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list, 0);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list, int depth) {
        if (node != null) {
            if (depth == list.size())
                list.add(node.val);

            helper(node.right, list, depth + 1);
            helper(node.left, list, depth + 1);
        }
    }


    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

