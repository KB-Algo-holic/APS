import java.io.*;

class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int len = A.length();
        for (int i = 0; i < len; i++) {
            if (A.equals(B)) {
                return i;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(A.charAt(len - 1)).append(A.substring(0, len - 1));

            A = sb.toString();
        }

        return answer;
    }
}
