import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();

            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            // BFS 를 통해 한 층씩 탐색을 한다.
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> subList = new LinkedList<Integer>();

                TreeNode node = null;
                for(int i = 0; i < size ; i ++ ) {
                    if (queue.peek().left != null)
                        queue.offer(queue.peek().left);
                    if (queue.peek().right != null)
                        queue.offer(queue.peek().right);
                    subList.add(queue.poll().val);
                }
                result.add(subList);
            }


            return result;
        }
}
