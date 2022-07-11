import java.util.LinkedList;

public class Q1696 {

    public static void main(String[] args) {

    }

    public int maxResult(int[] nums, int k) {
        int[] scores = new int[nums.length];
        LinkedList<Integer> queue = new LinkedList<>();

        // 초기화
        scores[0] = nums[0];
        queue.offer(0);


        for (int i = 1; i < nums.length; i++) {
            // 크기가 k인 슬라이딩 윈도우
            if (queue.getFirst() < i - k) {
                queue.removeFirst();
            }
            // 가장 마지막에 남은 값과 현재값을 더한다
            scores[i] = scores[queue.getFirst()] + nums[i];

            // 현재값보다 작은 값들을 지운다.
            while (!queue.isEmpty() && scores[queue.getLast()] <= scores[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        // 답
        return scores[nums.length - 1];
    }
}

