/*
    문제 : 양의 정수 n이 주어졌을때 0과 1로만 이루어진 숫자(Deci-Binary Numbers)를 더해서
         n을 만드는 최소한의 횟수를 구하는 문제
    난이도 : medium
    문제풀이 : 1의 자리수를 생각했을때 숫자의 크기만큼 1이 필요하다.
            두자리 수 이상의 수도 마찬가지로 각자리수를 생각하면 1이 필요한 만큼 개수가 나온다.
 */
import java.util.Scanner;

public class Q1689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

    }
    public int minPartitions(String n) {
        // n을 한 글자씩 자른다.
        String[] sp = new String[n.length()];
        sp = n.split("");
        int max =0;
        int digit;
        // 자른 글자를 정수형으로 변환하여 최대값을 구한다.
        for(int i = 0; i < n.length(); i++){
            digit = Integer.parseInt(sp[i]);
            if(max < digit) max = digit;
        }
        return max;
    }
}
