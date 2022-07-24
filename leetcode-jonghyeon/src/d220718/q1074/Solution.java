package d220718.q1074;

import java.util.Arrays;

public class Solution {
    static int result;
    static boolean[][] visited;

    static int numSubmatrixSumTarget(int[][] matrix, int target) {
        result = 0;
        visited = new boolean[matrix.length + 1][matrix[0].length + 1];
        recurse(matrix, target, 1, 1);
        return result;
    }

    static void recurse(int[][] matrix, int target, int w, int h) {

        int matWidth = matrix[0].length;
        int matHeight = matrix.length;
        if (w > matWidth || h > matHeight) return;
        if (visited[h-1][w-1]) return;
        visited[h-1][w-1] = true;

        for (int i = 0; i < matHeight - h + 1; i++) {
            for (int j = 0; j < matWidth - w + 1; j++) {
                int finalJ = j;
                try {
                    int sum = Arrays.stream(Arrays.copyOfRange(matrix, i, i + h))
                            .mapToInt(o -> Arrays.stream(Arrays.copyOfRange(o, finalJ, finalJ + w)).sum()).sum();
                    if (sum == target) result++;
                } catch (Exception e){
                    continue;
                }

            }
        }
        recurse(matrix, target, w + 1, h);
        recurse(matrix, target, w, h + 1);
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
//        int[][] matrix = new int[][]{{1,-1}, {-1,1}};
        int[][] matrix = new int[][]{{0, 1, 1, 1, 0, 1},{
            0, 0, 0, 0, 0, 1
        },{
            0, 0, 1, 0, 0, 1
        },{
            1, 1, 0, 1, 1, 0
        },{
            1, 0, 0, 1, 0, 0
        }};
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix, target));
    }
}
