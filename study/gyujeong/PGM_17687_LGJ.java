public class PGM_17687_LGJ {
    class Solution {

        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<m*t; i++) {
                sb.append(Integer.toString(i, n));
            }
            while (p <= m*t) {
                answer.append(String.valueOf(sb.charAt(p-1)));
                p += m;
            }
            return answer.toString().toUpperCase();
        }
    }
}
