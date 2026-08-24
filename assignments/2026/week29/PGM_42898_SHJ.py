# PGM 42898 - 등굣길
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42898

def solution(m, n, puddles):
    dp = [[0]*(m+1) for _ in range(n+1)]
    dp[1][1] = 1
    puddles = set(map(tuple, puddles))

    for y in range(1, n+1):
        for x in range(1, m+1):
            if (x, y) in puddles:
                dp[y][x] = 0
            elif (x, y) != (1, 1):
                dp[y][x] = (dp[y-1][x] + dp[y][x-1]) % 1000000007

    return dp[n][m]
