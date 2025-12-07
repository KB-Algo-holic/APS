// PGM - 땅따먹기
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/12913?language=java

import java.util.*;

class Solution {
    int solution(int[][] rows) {
        int answer = 0;
        int N = rows.length;
        int[][] dp = new int[N][4];

        for (int i=0; i<N; i++) {
            for (int j=0; j<4; j++) {
                if (i==0) dp[i][j] = rows[i][j];
                else {
                    int pre = i-1;
                    int max = 0;
                    for (int k=0; k<4; k++) {
                        if (j!=k && dp[pre][k] > max) {
                            dp[i][j] = rows[i][j] + dp[pre][k];
                            max = dp[pre][k];
                        }
                    }
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        for (int i=0; i<4; i++) {
            if (dp[N-1][i] > answer) answer = dp[N-1][i];
        }
        return answer;
    }
}