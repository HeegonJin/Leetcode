public class Q695 {
    static int[] dx = {-1,1,0,0};// 상하좌우
    static int[] dy = {0,0,-1,1};
    // 1로 이루어진 섬을 카운트할 변수
    static int count = 0;
    // dfs 탐색중 방문했는지 여부를 탐색할 변수
    static boolean[][] check;
    public static void main(String[] args) {

    }
    static public int maxAreaOfIsland(int[][] grid) {

        check = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0;  j < grid[0].length; j++){
                if(grid[i][j] == 1 && !check[i][j]){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        System.out.println(count);
        return count;
    }
    static void dfs(int[][] arr, int x, int y){
        // 방문했다면 true로 바꿔준다.
        check[x][y] = true;
        for(int i = 0; i < 4; i++){
            int n_dx = x + dx[i];
            int n_dy = y + dy[i];

            if(n_dx >= 0 && n_dy >= 0 && n_dx < arr.length && n_dy < arr.length) {
                if (arr[n_dx][n_dy] == 1 && !check[n_dx][n_dy]) {
                    dfs(arr, n_dx, n_dy);
                }
            }
        }
    }
}

