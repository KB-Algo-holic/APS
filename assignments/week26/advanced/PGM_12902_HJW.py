# PGM 12902 - 3 x n 타일링
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12902

K = 1000000007

def solution(n):
    dp = [0] * 5001
    dp[0] = 1
    dp[2] = 3
    for i in range(4, 5001, 2):
        dp[i] = (4*dp[i-2] - dp[i-4])%K
        
    return dp[n]