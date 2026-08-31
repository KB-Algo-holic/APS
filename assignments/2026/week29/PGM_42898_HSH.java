package week29;
public class PGM_42898_HSH {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PGM_42898_HSH sol = new PGM_42898_HSH();
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        int result = sol.solution(m, n, puddles);
        System.out.println(result);
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        int MOD = 1_000_000_007;
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1)
                    continue;
                if (i > 1)
                    dp[i][j] += (dp[i - 1][j] == -1 ? 0 : dp[i - 1][j]);
                if (j > 1)
                    dp[i][j] += (dp[i][j - 1] == -1 ? 0 : dp[i][j - 1]);

                dp[i][j] %= MOD;
            }
        }

        return dp[n][m] == -1 ? 0 : dp[n][m];
    }
}