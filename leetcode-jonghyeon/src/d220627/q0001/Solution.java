package d220627.q0001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            }
            map.put(target-nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
