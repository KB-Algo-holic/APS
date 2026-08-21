# PGM 42898 - 등굣길
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42898

def solution(m, n, puddles):
    
    p = 1000000007
    grid = [[1 for _ in range(m)] for _ in range(n)]
    for x, y in puddles:
        grid[y-1][x-1] = 0
    DP = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(n):
        DP[i][0] = grid[i][0]
    for j in range(m):
        DP[0][j] = grid[0][j]
        
    DP[0][0] = 1
    for i in range(n):
        for j in range(m):
            if not i and not j:
                continue
            if grid[i][j]:
                DP[i][j] = DP[i-1][j] + DP[i][j-1]
                DP[i][j] %= p

    return DP[n-1][m-1]