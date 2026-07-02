// PGM - 12914 L2_멀리뛰기
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/12914?language=java
public class PGM_12914_YHS {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        // System.out.println(Arrays.toString(dp));
        answer = dp[n];

        return answer;
    }
}