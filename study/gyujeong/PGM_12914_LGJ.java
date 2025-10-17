// PGM 멀리뛰기
// DP 기초
// https://school.programmers.co.kr/learn/courses/30/lessons/12914

public class PGM_12914_LGJ {


    class Solution {
        public static long solution(int n) {
            long[] dp = new long[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2])% 1234567; // n-1에서 한칸+n-2에서 두칸
            }

            return dp[n];
        }

    }
}
