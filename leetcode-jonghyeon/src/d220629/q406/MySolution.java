package d220629.q406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MySolution {
    static int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++){
            for (int j = 0; j < 2; j++){
                result[i][j] = -1;
            }
        }
        boolean[] visited = new boolean[people.length];
        int positionCount = 0;
        int prev = 0;

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        for (int[] p : people) {
            int i = 0;
            prev = Arrays.stream(result).filter(x -> x[0] >= p[0]).collect(Collectors.toList()).size();

            while (true) {
                if (visited[i] == true) {
                    positionCount++;
                    i++;
                    continue;
                }
                if (prev == p[1] || i == people.length-1) {
                    visited[i] = true;
                    break;
                }
                positionCount++;
                prev++;
                i++;
            }
            result[positionCount] = p;
            positionCount = 0;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] people = new int[][]{{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}};
        int[][] result = reconstructQueue(people);
        int m = result.length;
        int n = result[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}

