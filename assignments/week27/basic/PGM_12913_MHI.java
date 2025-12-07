class Solution {
    static int[][] dp;
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }
            }
        }

        return Math.max(Math.max(dp[n-1][0], dp[n-1][1]),
                Math.max(dp[n-1][2], dp[n-1][3]));
    }
}