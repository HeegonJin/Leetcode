package d220715.q695;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static int count;

    static int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int depth = 0;
                    recurse(i, j, grid, visited, areas, depth);
                }
            }
        }
        if (areas.isEmpty()) return 0;
        return Collections.max(areas);

    }

    static boolean recurse(int i, int j, int[][] grid, boolean[][] visited, List<Integer> areas, int depth) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || visited[i][j]) return false;
        if (grid[i][j] == 1) {
            count++;
            visited[i][j] = true;
            recurse(i + 1, j, grid, visited, areas, depth + 1);
            recurse(i - 1, j, grid, visited, areas, depth + 1);
            recurse(i, j + 1, grid, visited, areas, depth + 1);
            recurse(i, j - 1, grid, visited, areas, depth + 1);
            if (depth == 0){
                areas.add(count);
                count = 0;
            }
        } else return false;
        return true;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {
                0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {
                0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
