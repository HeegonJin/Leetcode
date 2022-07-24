package d220723.q315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CorrectSolution {
    static List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();


        for(int num: nums) arr.add(num);

        Collections.sort(arr);

        for(int i = 0; i<len; i++){
            int index = binarySearch(arr,nums[i]);
            ans.add(index);
            arr.remove(index);
        }

        return ans;

    }

    static int binarySearch(List<Integer> arr, int target){
        int start = 0;
        int end = arr.size()-1;
        int mid=0;

        while(start<=end){
            mid = start + ((end - start)/2);
            int val = arr.get(mid);
            if(val<target) start = mid + 1;
            else end = mid - 1;
        }
        if(arr.get(start) == target) return start;
        return mid;
    }

    static List<Integer> countSmaller2(int[] nums) {
        int min = 20001;
        int max = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        min--;
        int[] count = new int[max-min+1];
        Integer[] result = new Integer[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
            int k = nums[i]-min-1;
            int c = 0;
            do {
                c += count[k];
                k -= (-k&k);
            } while (k > 0);
            result[i] = c;

            k = nums[i]-min;
            while (k < count.length) {
                count[k]++;
                k += (-k&k);
            }
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,4,3,6,9,11,3,2,1};
        System.out.println(countSmaller2(input));
    }
}
