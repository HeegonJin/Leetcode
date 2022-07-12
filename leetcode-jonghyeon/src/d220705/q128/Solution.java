package d220705.q128;

import java.util.*;

public class Solution {
    static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> freq = new TreeMap<>();
        PriorityQueue<Integer> candidate = new PriorityQueue<>(Collections.reverseOrder());
        int result = 1;

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (var entry : freq.entrySet()) {
            int value = entry.getValue();
            while (value-- > 0) {
                nums[index++] = entry.getKey();
            }
        }

        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i + 1] == nums[i]) continue;
            else if (nums[i + 1] == nums[i] + 1) result++;
            else {
                candidate.offer(result);
                result = 1;
            }
        }
        candidate.offer(result);
        return candidate.poll();
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,-2,7,2,5,-5,-3,8,4,6,0,1 };
        System.out.println(longestConsecutive(nums));
    }

}
