package d220706.q509;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    static int fib(int n) {
        Map<Integer, Integer> bucket = new HashMap<>();
        bucket.put(0,0);
        bucket.put(1,1);
        int index = 2;
        while(index <= n){
            bucket.put(index, bucket.get(index-1)+ bucket.get(index-2));
            index++;
        }
        return bucket.get(n);
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(fib(n));
    }
}
