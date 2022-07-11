import java.util.Scanner;

public class Q1423 {
    public static void main(String[] args) {
        int[] a = {1,79,80,1,1,1,200,1};
        int n = 3;

        System.out.println(maxScore(a,n));
    }
    public static int maxScore(int[] cardPoints, int k) {

        // 배열의 처음과 끝을 가릴킬 변수
        int start = cardPoints.length - k ;

        int sum = 0;
        int max = 0;
        int count = 0;

        if (cardPoints.length == k){
            for (int i=0; i <  cardPoints.length; i ++) {
                sum += cardPoints[i];
            }
            return sum;
        }
        for(int i=0; i < 2*k; i++){
            sum += cardPoints[(i+start)%cardPoints.length];
            count++;
            if( count >=k ){
                if(max <= sum) max = sum;
                sum -= cardPoints[(i+start-k+1)% cardPoints.length];

            }

        }
        return max;
    }
}

