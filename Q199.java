import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {
    /*
    * BFS를 통한 문제 풀이
    *
    * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // BFS 를 통해 한 층씩 탐색을 한다.
        // Queue의 사이즈를 확인한 다음 가장 마지막 값을 출력한다.
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            while (size > 0) {
                node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            list.add(node.val);
        }

        return list;
    }
    }

