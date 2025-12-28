# PGM 43105 - 정수 삼각형
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43105

def solution(triangle):
    DP = triangle
    height = len(triangle)
    for i in range(1,height):
        DP[i][0] = DP[i-1][0] + triangle[i][0]
        DP[i][-1] = DP[i-1][-1] + triangle[i][-1]
    for i in range(2, height):
        for j in range(1, len(triangle[i])-1):
            tmp1 = DP[i-1][j-1]
            tmp2 = DP[i-1][j]
            if tmp1 > tmp2:
                DP[i][j] = tmp1 + triangle[i][j]
            else:
                DP[i][j] = tmp2 + triangle[i][j]
    answer = 0
    for i in range(height):
        if answer < DP[height - 1][i]:
            answer = DP[height - 1][i]
    return answer