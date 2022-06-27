package d220627.q1689;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Soluiton {
    public class Solution {
        static int minPartitions(String n) {
            String[] strings = n.split("");
            List<Integer> results = new ArrayList<>();
            Arrays.asList(strings).forEach(s -> {
                results.add(Integer.parseInt(s));
            });
            Integer max = Collections.max(results);
            return max;
        }

        public static void main(String[] args) {
            minPartitions("121381237902");
        }
    }
}
