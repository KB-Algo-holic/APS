// PGM 12914 - 멀리 뛰기
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/12914

class Solution {
    public long solution(int n) {


        int[] dp = new int[n+2];

        dp[0]=1;

        for(int i=0; i<n; i++){
            dp[i+2] = (dp[i+2]+dp[i])%1234567;
            dp[i+1] = (dp[i+1]+dp[i])%1234567;
        }


        return dp[n];
    }
}