package d220629.q406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0]!=y[0] ? x[0]-y[0] : x[1]-y[1]);
        for(int[] person: people) queue.offer(person);
        int[][] result = new int[people.length][];
        while(!queue.isEmpty()) {
            int[] person = queue.poll();
            for(int i=0, aheadCount = 0;i<result.length;i++) {
                if(aheadCount == person[1] && result[i] == null) {
                    result[i] = person;
                    break;
                }
                if(result[i] == null || result[i][0] == person[0]) aheadCount++;
            }
        }
        return result;
    }

    public static void main (String[]args){
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
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

