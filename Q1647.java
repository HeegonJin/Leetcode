import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Q1647 {
    public static void main(String[] args) {
        String test = "abcdeeddffeeffggg";
        minDeletions(test);
    }
    public static int minDeletions(String s) {

        int size = s.length();
        String[] temp = new String[size];

        // 입력값을 정렬해기위해 split 해준다.
        temp = s.split("");

        int[] alpa = new int[size];
        int[] fq = new int[26];
        // 알파벳을 정수로 변경
       for(int i = 0; i < size; i++){
            alpa[i] = (temp[i].charAt(0)-97);
            fq[alpa[i]]++;
        }

       // 정렬
        Arrays.sort(fq);

       // HashSet을 이용하여 중복된 수를 찾는다.
        HashSet set= new HashSet<>();
        int result =0;
       for(int i = 0; i < 26; i++){

           while(fq[i]>0 && set.contains(fq[i])) {
               fq[i]--;
               result++;
           }
           set.add(fq[i]);
       }
        return result;
    }
}
