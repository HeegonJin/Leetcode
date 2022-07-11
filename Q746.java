public class Q746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] sum = new int[n + 1];
        // 초기화
        sum[0] = 0;
        sum[1] = 0;
        // i-1, i-2 최솟값을 찾는다.
        for (int i = 2; i <= n; ++i) {
            sum[i] = Math.min(sum[i - 1] + cost[i - 1], sum[i - 2] + cost[i - 2]);
        }
        return sum[n];
        }
    }

