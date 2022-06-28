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
            if (i == strings.length - 1 ) {
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

        Integer hole;
        list.sort(null);
        System.out.println(list);

            if (list.get(0) <= 1) hole = null;
            else hole = list.get(0) - 1;

            for (int i = 0; i < list.size(); i++) {
                if (i == list.size()-1) {
                    continue;
                }
                if (list.get(i) != list.get(i + 1)) {
                    if (list.get(i + 1) - list.get(i)  == 1) continue;
                    else hole = list.get(i+1) - 1;
                } else {
                    if (hole == null) {
                        result += list.get(i);
                        list.remove(i);
                    } else {
                        result += list.get(i) - hole;
                        list.set(i, list.get(i) - hole);
                        list.sort(null);
                    }
                    hole = (hole != null && hole - 1 > 0) ? hole - 1 : null;
                }
            }
        return result;
    }


    public static void main(String[] args) {
        minDeletions("jbddhjemmnhaflahionjoddojoliimdcailihfdleahgbafnknblkheeicoonffenhhmgfhgmnjk");
    }
}
