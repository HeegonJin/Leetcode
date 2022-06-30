package d220630.q462;

import java.util.Arrays;

public class Solution {
    static int minMoves2(int[] nums) {
        int result;
        Arrays.sort(nums);
        int mid = nums.length / 2;
        result = Arrays.stream(nums).map(num -> Math.abs(num - nums[mid])).sum();
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 10, 2, 9};
        System.out.println(minMoves2(ints));
    }
}
