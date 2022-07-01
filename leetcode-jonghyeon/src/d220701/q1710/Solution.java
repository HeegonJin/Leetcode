package d220701.q1710;

import java.util.PriorityQueue;

public class Solution {
    static int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int[] box : boxTypes) {
            queue.offer(box);
        }
        while (truckSize > 0) {
            int[] box = queue.poll();

            truckSize -= box[0];
            result += box[0] * box[1];

            if (truckSize < 0){
                result -= Math.abs(truckSize) * box[1];
                truckSize = 0;
            }
            if (queue.isEmpty()){
                break;
            }

        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        maximumUnits(new int[][] {{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}}, 35);
    }
}
