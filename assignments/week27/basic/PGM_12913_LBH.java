// PGM 12913 - 땅따먹기
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/12913

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];

        for(int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int max = 0;

                for(int k = 0; k < 4; k++) {
                    if(j != k) {
                        if(max < dp[i - 1][k] + land[i][j]) {
                            max = dp[i - 1][k] + land[i][j];
                        }
                    }
                }

                dp[i][j] = max;
            }
        }

        int answer = 0;
        for(int j = 0; j < 4; j++) {
            if(answer < dp[land.length - 1][j]) {
                answer = dp[land.length - 1][j];
            }
        }

        return answer;
    }
}