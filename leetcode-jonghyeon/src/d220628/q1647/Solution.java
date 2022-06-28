package d220628.q1647;

import java.util.*;

public class Solution {
    static int minDeletions(String s) {
        int result = 0;
        String[] strings = s.split("");
        List<Integer> list = new ArrayList<>();
        Arrays.sort(strings);
        int count = 1;

        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {
                list.add(count);
                continue;
            }
            if (strings[i].equals(strings[i + 1])) {
                count++;
                continue;

            } else {
                list.add(count);
                count = 1;
            }
        }
        list.sort(null);
        count = 1;
        ArrayList<Integer> holes = new ArrayList<>();

        Map<Integer, Integer> target = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                for (int j = 1; j < list.get(i); j++) {
                    holes.add(j);
                }
            }
            if (i == list.size() - 1) {
                if (count > 1) {
                    target.put(list.get(i), count-1);
                }
                continue;
            }
            if (list.get(i).equals(list.get(i + 1))) {
                count++;
                continue;
            } else {
                if (count > 1) {
                    target.put(list.get(i), count-1);
                    count = 1;
                }
                for (int j = list.get(i) + 1; j < list.get(i + 1); j++) {
                    holes.add(j);
                }
            }
        }

        if (Collections.max(target.entrySet(), Comparator.comparingInt(Map.Entry::getKey)).getKey() < holes.get(holes.size()-1)){
            holes.remove(holes.size()-1);
        }

        int targetSize = target.values().stream().mapToInt(Integer::intValue).sum();
        int holeSize = holes.size();
        int targetSum = target.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();

        if (targetSize > holeSize){
            result = targetSum - holes.stream().mapToInt(Integer::intValue).sum();
        } else{
            for (int i = 0; i < targetSize; i++){
                targetSum -= holes.get(holeSize - 1 - i);
            }
            result = targetSum;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        minDeletions("fblkeacljlekiiddgbdibbhfafgmigghfiejilnjbclejlcabgkocbbbhnalmikjojildlfhjdgbgdhooiddbniedaabmk");
    }
}