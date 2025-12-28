// PGM 2*n 타일
// DP 기초
// https://school.programmers.co.kr/learn/courses/30/lessons/12900



public class PGM_12900_LGJ {

    class Solution {
        public int solution(int n) {
            int answer = 0;
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i=2; i<=n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            }

            return dp[n];
        }
    }

    long[] dp;
    public long solution(int n) {
        dp = new long[n + 1];
        return jump(n);
    }

    // 재귀적으로 계산 (Top-Down)
    private long jump(int n) {
        // 기저 조건
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 이미 계산한 적이 있으면 재사용
        if (dp[n] != 0) return dp[n];

        // 점화식: n칸 가는 방법 = n-1칸 + n-2칸
        dp[n] = (jump(n - 1) + jump(n - 2)) % 1234567;

        return dp[n];
    }
}
