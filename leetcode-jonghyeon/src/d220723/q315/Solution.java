package d220723.q315;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static List<Integer> countSmaller(int[] nums) {

        Map<Integer, Integer> indexValueMap = new TreeMap<>();
        Map<Integer, Integer> resultMap = new TreeMap<>();
        Map<Integer, Integer> excluded = new TreeMap<>();
        for (int i = 0; i < nums.length; i++){
            indexValueMap.put(i, nums[i]);
        }
        recurse(indexValueMap, resultMap, excluded);
        return new ArrayList<>(resultMap.values());
    }

    static void recurse(Map<Integer, Integer> inputMap, Map<Integer, Integer> resultMap, Map<Integer, Integer> excluded) {
        if (inputMap.isEmpty()) return;
        Map<Integer, Integer> lowerInputMap = new TreeMap<>();

        Set<Map.Entry<Integer, Integer>> entrySet = new LinkedHashSet<>(inputMap.entrySet());
        List<Map.Entry<Integer, Integer>> collect = entrySet.stream().collect(Collectors.toList());
        Map.Entry<Integer, Integer> criteria = collect.get(0);

        for (Map.Entry<Integer, Integer> e : entrySet) {
            if (e.getValue() < criteria.getValue()) {
                lowerInputMap.put(e.getKey(), e.getValue());
                inputMap.remove(e.getKey());
                collect.remove(e);
            }
        }

        recurse(lowerInputMap, resultMap, excluded);
        excluded.put(criteria.getKey(), criteria.getValue());
        excluded.putAll(lowerInputMap);

        resultMap.put(criteria.getKey(), (int) excluded.entrySet().stream().filter(e ->  e.getKey() > criteria.getKey()).count());
        inputMap.remove(criteria.getKey());
        recurse(inputMap, resultMap, excluded);
    }


    public static void main(String[] args) {
//        int[] input = new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        int[] input = new int[]{5,4,3,6,9,11,3,2,1};
        System.out.println(countSmaller(input));
    }
}
