import java.util.Arrays;
import java.util.Collections;

public class Q473 {
    //  한 변의 길이
    static int side;
    // 네 변
    static int[] sum = new int[4];
    // 막대기를 저장할 변수
    static Integer[] arr;

    public static void main(String[] args) {
        int[] test = {10,6,5,5,5,3,3,3,2,2,2,2};
        System.out.println(makesquare(test));
    }
    public static boolean makesquare(int[] matchsticks) {

        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        side = sum / 4;
        // 모든 막대의 합이 4로 나누어 떨어지지 않거나 막대가 4개 이하일때
        if(sum % 4 != 0 || matchsticks.length < 4) return false;

        // 백트래킹을 위하여 내림차순으로 정렬
        arr = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        return dfs(0);
    }
    public static boolean dfs(int index){
        // 모든 막대를 탐색 했다면 결과를 반환한다.
        if(index == arr.length){
            // 네변의 길이가 같을때만 true
            return sum[0]==sum[1]&&sum[1] ==sum[2]&& sum[2] == sum[3] ;
        }
        // 각
        for(int i = 0 ; i < 4; i++){
            if(sum[i]+arr[index] <= side) {
                sum[i] += arr[index];
                if( dfs(index+1)) return true;
        }
            sum[i] -= arr[index];
//            System.out.println(sum[i]);

        }
        return false;
    }
}
