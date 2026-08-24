// PGM _ 42898 등굣길
//https://school.programmers.co.kr/learn/courses/30/lessons/42898

import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < puddles.length; i++){
            int[] tmp = puddles[i];
            dp[tmp[0]][tmp[1]] = -1;
        }
        dp[1][1] = 1;
        for(int i = 1;i < dp.length; i++){
            for(int j = 1;j < dp[i].length; j++){
                if(i == 1 && j == 1)
                    continue;
                if(dp[i][j] != -1){
                    if(dp[i -1][j] == -1)
                        dp[i -1][j] = 0;
                    if( dp[i][j - 1] == -1)
                         dp[i][j - 1] = 0;
                    dp[i][j] = (dp[i -1][j] + dp[i][j - 1]) % 1000000007;
                    
                }
            }
        }
        return dp[m][n];
    }
}
