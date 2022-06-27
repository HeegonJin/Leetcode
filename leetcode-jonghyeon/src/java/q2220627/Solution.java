package java.q2220627;

import java.util.*;

public class Solution {
    static int minPartitions(String n) {
        String[] strings = n.split("");
        List<Integer> results = new ArrayList<>();
        Arrays.asList(strings).forEach(s -> {
            results.add(Integer.parseInt(s));
        });
        results.sort(null);
        System.out.println(results.get(results.size()-1));
        return results.get(results.size()-1);
    }

    public static void main(String[] args) {
        minPartitions("121381237902");
    }
}
