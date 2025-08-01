# PGM 42898 - 등굣길
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42898

def solution(m, n, puddles):

    DP = [[0 for j in range(m)] for i in range(n)]

    for puddle in puddles:
        DP[puddle[1]-1][puddle[0]-1] = -1

    DP[0][0] = 1
    for j in range(1, m):
        if DP[0][j-1] == 1 and DP[0][j] != -1:
            DP[0][j] = 1
        else:
            DP[0][j] = -1
    for i in range(1, n):
        if DP[i-1][0] == 1 and DP[i][0] != -1:
            DP[i][0] = 1
    
    for i in range(1, n):
        for j in range(1, m):
            if DP[i][j] != -1:
                if DP[i-1][j] == -1:
                    tmp1 = 0
                else:
                    tmp1 = DP[i-1][j]
                if DP[i][j-1] == -1:
                    tmp2 = 0
                else:
                    tmp2 = DP[i][j-1]
                DP[i][j] = (tmp1 + tmp2) % 1000000007
                
    answer = DP[n-1][m-1]

    return answer