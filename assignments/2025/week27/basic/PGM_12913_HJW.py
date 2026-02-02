# PGM 12913 - 땅따먹기
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12913

def solution(land):
    answer = 0
    
    N = len(land)
    dp = [[0 for _ in range(4)] for _ in range(N)]
    for i in range(4):
        dp[0][i] = land[0][i]
    
    for i in range(1, N):
        for j in range(4):
            tmp = []
            for k in range(4):
                if j != k:
                    tmp.append(dp[i-1][k])
            dp[i][j] = max(tmp) + land[i][j]
    
    answer = max(dp[N-1])
    return answer