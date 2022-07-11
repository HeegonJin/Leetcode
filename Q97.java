public class Q97 {
    public static void main(String[] args) {

        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        int left = 0;
        int right = 0;

        int count = 0;
        for (int i = 0; i < s3.length(); i++){
           char ch = s3.charAt(i);
           boolean flag = false;
           if(s1.charAt(left) == ch){
               if(left < s1.length()-1) left++;
               flag = true;

           }
           else if(s2.charAt(right) ==ch && flag == false){
               if(right < s2.length()-1) right++;

            }
           else count++;
        }
        if(count != 0) return false;
        else return true;

        }
    }

