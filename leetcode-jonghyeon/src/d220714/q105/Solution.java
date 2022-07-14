package d220714.q105;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        Queue<Integer> preorderQueue = new LinkedList<>();
        for (int i : preorder) {
            preorderQueue.add(i);
        }
        TreeNode node = new TreeNode();
        return recurse(node, preorderQueue, inorderList);

    }

    static TreeNode recurse(TreeNode node, Queue<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty() || inorder.isEmpty()) return null;
        node.val = preorder.poll();
        int index = inorder.indexOf(node.val);
        node.left = recurse(new TreeNode(), preorder, inorder.subList(0, index));
        node.right = recurse(new TreeNode(), preorder, inorder.subList(index + 1, inorder.size()));
        return node;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
    }
}
