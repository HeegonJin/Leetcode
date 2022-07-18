public class Q576 {
    public static void main(String[] args) {

    }

    static public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

                // 크기 제한
                int t = 1000000007;
                int dp[][] = new int[m][n];
                // 볼의 위치
                dp[startRow][startColumn] = 1;
                int count = 0;
                for (int moves = 1; moves <= maxMove; moves++) {
                    // 다음 볼의 위치들을 저장할 배열
                    int[][] temp = new int[m][n];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            // 엣지칸에 올경우 count + 1
                            if (i == m - 1) count = (count + dp[i][j]) % t;
                            if (j == n - 1) count = (count + dp[i][j]) %t;
                            if (i == 0) count = (count + dp[i][j]) % t ;
                            if (j == 0) count = (count + dp[i][j]) %t;
                            temp[i][j] = (
                                    // 상하좌우 한칸씩 갈수 있는지 없는지 확인후 이동
                                    ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) %t +
                                            ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) %t
                            );
                        }
                    }
                    dp = temp;
                }
                return count;
    }
}
