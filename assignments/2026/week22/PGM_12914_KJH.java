// PGM 12914 - 멀리뛰기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12914
class Solution {
    public long solution(int n) {
        
        // n이 1인 경우 미리 예외 처리 (배열 크기 오류 방지)
        if (n == 1) return 1;
        
        // dp 배열 선언 (n번째 칸까지의 방법의 수를 저장)
        long[] dp = new long[n + 1];
        
        // 초기값 설정
        dp[1] = 1; // 1칸일 때 방법은 1가지
        dp[2] = 2; // 2칸일 때 방법은 2가지
        
        // 점화식을 이용해 3번째 칸부터 n번째 칸까지 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
