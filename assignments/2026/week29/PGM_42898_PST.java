// PGM 42898 - 등굣길
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=java

public class PGM_42898_PST {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            dp[y][x] = -1;
        }

        dp[1][1] = 1;

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if ((r == 1 && c == 1) || dp[r][c] == -1) {
                    continue;
                }

                if (r > 1 && dp[r - 1][c] != -1) {
                    dp[r][c] = (dp[r][c] + dp[r - 1][c]) % MOD;
                }

                if (c > 1 && dp[r][c - 1] != -1) {
                    dp[r][c] = (dp[r][c] + dp[r][c - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}
