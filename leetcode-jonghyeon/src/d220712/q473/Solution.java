package d220712.q473;

import java.util.Arrays;

public class Solution {
//    static boolean makesquare(int[] matchsticks) {
//        int sum = Arrays.stream(matchsticks).sum();
//        if (sum % 4 != 0) return false;
//        int side = sum / 4;
//
//        Queue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
//        Queue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i : matchsticks) pq1.add(i);
//        int count = 0;
//        boolean check = true;
//        while (true) {
//            if (count == 4) break;
//            Integer polled = check ? pq1.poll() : pq2.poll();
//            if (polled == side) {
//                count++;
//                continue;
//            } else if (polled > side) return false;
//            else {
//                int subSum = polled;
//                while (subSum <= side) {
//                    polled = check ? pq1.poll() : pq2.poll();
//                    if (polled == null) {
//                        check = !check;
//                        continue;
//                    }
//                    if (subSum + polled == side) {
//                        count++;
//                        break;
//                    } else if (subSum + polled > side) {
//                        if (check) {
//                            pq2.add(polled);
//                        } else {
//                            pq1.add(polled);
//                        }
//                    } else {
//                        subSum += polled;
//                    }
//                }
//
//            }
//        }
//        return true;
//    }
//    static boolean makesquare2(int[] matchsticks) {
//
//        int total = 0;
//
//        for (int i : matchsticks) {
//            total += i;
//        }
//
//        if (total % 4 != 0) return false; // if we cant make 4 equals sides then theres no way to make a square
//        // sort the array and place the largest sides first. required optimization to not TLE
//        Arrays.sort(matchsticks);
//        return match(matchsticks, matchsticks.length - 1, 0, 0, 0, 0, total / 4);
//    }
//
//    static boolean match(int[] matchsticks, int index, int top, int bottom, int left, int right, int target) {
//
//        if (top == target && bottom == target && left == target && right == target) return true;
//
//        if (top > target || bottom > target || left > target || right > target) return false;
//
//        int val = matchsticks[index];
//
//        boolean t = match(matchsticks, index - 1, top + val, bottom, left, right, target);
//        if (t) return true;
//        boolean b = match(matchsticks, index - 1, top, bottom + val, left, right, target);
//        if (b) return true;
//        boolean l = match(matchsticks, index - 1, top, bottom, left + val, right, target);
//        if (l) return true;
//        boolean r = match(matchsticks, index - 1, top, bottom, left, right + val, target);
//        if (r) return true;
//
//        return false;
//    }

    static boolean makesquare3(int[] matchsticks){
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int sideLength = sum / 4;
        int[] sides = new int[4];
        return backtrack(0,matchsticks,sides,sideLength);
    }

    static boolean backtrack(int index, int[] matchsticks, int[] sides, int sideLength){
        if (index == matchsticks.length) return true;
        for (int i = 0; i < 4; i++){
            if (sides[i] + matchsticks[index] <= sideLength){
                sides[i] += matchsticks[index];
                if (backtrack(index+1, matchsticks, sides, sideLength)){
                    return true;
                }
                sides[i] -= matchsticks[index];
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        System.out.println(makesquare(new int[]{1,1,2,2,2}));
//        Queue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
//    }
}
