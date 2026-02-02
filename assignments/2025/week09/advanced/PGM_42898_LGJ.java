// PGM - 등굣길
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/42898

class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];

        // 웅덩이 체크
        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }

        dp[1][1] = 1; // 시작점

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 1) dp[i][j] += dp[i-1][j];
                if (j > 1) dp[i][j] += dp[i][j-1];
                dp[i][j] %= 1000000007;
            }
        }

        return dp[m][n];
    }
}