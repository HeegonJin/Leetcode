package d220704.q135;

public class Solution {
    static int candy(int[] ratings) {
        int size = ratings.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = 1;
        right[size-1] = 1;
        for(int i = 1; i < size; i++){
            if(ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        for(int i = size - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }

        int answer = 0;
        for(int i = 0; i < size; i++){
            answer+=Math.max(left[i], right[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 0, 2};
//        int[] list = new int[]{5,6,7,1,3,4,6};
        System.out.println(candy(list));
    }
}
