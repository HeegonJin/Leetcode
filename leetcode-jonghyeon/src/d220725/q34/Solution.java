package d220725.q34;

import java.util.Arrays;

public class Solution {
    static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) break;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (left > right || nums.length == 0) return new int[]{-1, -1};

        int count = 0;
        boolean rightCheck = false;
        boolean leftCheck = false;
        while (!rightCheck || !leftCheck) {
            count++;


            if (!rightCheck) {
                if (mid + count >= nums.length) {
                    right = mid + count - 1;
                    rightCheck = true;
                } else {
                    if (nums[mid + count] != target) {
                        right = mid + count - 1;
                        rightCheck = true;
                    }
                }
            }
            if (!leftCheck) {
                if (mid - count < 0) {
                    left = mid - count + 1;
                    leftCheck = true;
                } else {
                    if (nums[mid - count] != target) {
                        left = mid - count + 1;
                        leftCheck = true;
                    }
                }
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{1};
        int target = 1;
        int[] ans = searchRange(nums, target);
        Arrays.toString(ans);
    }
}
