package week06;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_HSH {
    public static void main(String[] args) throws IOException {
        BOJ_9251_HSH sol = new BOJ_9251_HSH();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int result = sol.solution(A, B);

        System.out.println(result);
    }

    public int solution(String A, String B) {
        // LCS 알고리즘
        /***
         * A = ACAYKP
         * B = CAPCAK
         * 
         * 두 문자열에서 순서를 유지하면서 가장 길게 겹치는 부분이 답
         * 1) A랑 B가 길게 나오는거 하나 dp[0]
         * 2) A랑 B가 길게 나오는거 하나 dp[1] ...
         * 
         * 예를 들어, A의 A부터해서 B랑 비교할 때 길게 나올 수 있는거 CAP = dp[1][0]
         * 그 다음 A의 B부터해서 B랑 비교할 때 길게 나올 수 있는거 CAK = dp[1][3]
         * ...
         * ...
         * ...
         * 이렇게 해서 dp를 비교함 -> 가장 긴 것이 LCS의 알고리즘의 답
         */

        int dp[][] = new int[A.length() + 1][B.length() + 1]; // 처음은 다 0으로 초기화됨
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    /**
                     * A = ABCD
                     * B = ACBD
                     * 
                     * 이거라하면 우선 A == A 이기 때문에 첫 번째부터 히트이므로 +1
                     */
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    /**
                     * 둘이 다를 경우 다음꺼로 이동해서 하고.. 그 중 최고치가 현재 가장 긴 길이로 처리
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[A.length()][B.length()];
    }
}
