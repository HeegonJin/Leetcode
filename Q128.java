import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Q128 {
    public static void main(String[] args) {

        int[] num = {1, 3, 5, 2, 4};
        System.out.println(longestConsecutive(num));
    }

    public static int longestConsecutive(int[] nums) {

        int result = 0;
        // HashSet을 이용해서 중복된 수를 제거해준다.
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        // ex) 5, 4, 3, 2, 6, 7, 8 이라고 했을때 5부터 시작한다.
        for (int i : nums) {
            // 현재값을 카운트 했으므로 max는 부터 1부터 시작
            int max = 1 ;
            int pre = i-1;
            // 현재 i 값 기준으로 큰 값  ex ) 6
            int next = i+1;
            // 현재 i 보다 1 작은 값이 존재하면 반복 ex ) 4
            while (set.contains(pre)){ // 4가 존재하므로 max 1 증가 후 4는 Set에서 뺀다
                max ++;
                set.remove(pre--);
            }
            // 현재 i 보다 1 큰 값이 존재하면 반복 ex ) 6
            while (set.contains(next)){// 6가 존재하므로 max 1 증가 후 6는 Set에서 뺀다
                max ++;
                set.remove(next++);
            }
            // 연속된 숫자가 전혀 없을 경우 0을 반
            result = Math.max(result, max);
        }
        return result;


    }
}
