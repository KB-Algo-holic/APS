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
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567; // n-1에서 한칸+n-2에서 두칸
            }

            return dp[n];
        }
    }

    long[] dp;

    public long solution(int n) {
        dp = new long[n + 1];
        return tile(n);
    }

    private long tile(int n) {
        // 기저 조건
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 이미 계산한 값이 있다면 재사용
        if (dp[n] != 0) return dp[n];

        // 점화식 적용: dp[n] = dp[n-1] + dp[n-2]
        dp[n] = (tile(n - 1) + tile(n - 2)) % 1000000007;
        return dp[n];
    }
}
