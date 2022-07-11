import java.util.Arrays;

public class Q135 {
    public static void main(String[] args) {
        int[] test = {1,0,2};
        System.out.println(candy(test));
    }

    public static int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        // 사탕을 최소 1개씩 준다.
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                left[i] = left[i-1]+1;
            }
            else {
                left[i] = 1;
            }
            }

            for (int i = ratings.length-2; i >= 0 ; i--) {
                if(ratings[i] > ratings[i +1]) {
                    right[i] = right[i+1]+1;
                }
                else {
                    right[i] = 1;
                }
            }

        int result = 0;
        for (int i = 0 ; i < ratings.length; i ++){
            result += Math.max(left[i],right[i]);
            System.out.println(left[i] +" : " + right[i]);
        }
        return result;
    }

}
