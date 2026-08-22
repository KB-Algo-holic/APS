// PGM - 42898 등굣길
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/42898


import java.util.*;

class Solution {

    public int solution(int m, int n, int[][] puddles) {
        // 격자 위치 반대
        int[][] dp = new int[n+1][m+1];

        for (int[] puddle: puddles) dp[puddle[1]][puddle[0]] = -1;

        for (int r=2; r<n+1; r++) {
            if (dp[r][1] == -1) break;
            dp[r][1] = 1;
        }
        for (int c=2; c<m+1; c++) {
            if (dp[1][c] == -1) break;
            dp[1][c] = 1;
        }

        //System.out.println(Arrays.deepToString(dp));

        for (int r=2; r<n+1; r++) {
            for (int c=2; c<m+1; c++) {
                if (dp[r][c] == -1) continue;
                int br = dp[r-1][c] == -1 ? 0 : dp[r-1][c]; //before r
                int bc = dp[r][c-1] == -1 ? 0 : dp[r][c-1]; //before c
                dp[r][c] = (br + bc) % 1000000007;
            }
        }
        //System.out.println(Arrays.deepToString(dp));


        return dp[n][m];
    }
}