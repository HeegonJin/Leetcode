/*
* 문제 : 피보나치 수열
* 난이도 : easy
* 풀이방법 : 재귀
*
* */
public class Q509 {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static int fib(int n) {
        if(n > 1)
            return fib(n-1)+fib(n-2);
        else if(n ==1)
            return 1;
        else return 0;
    }
}

