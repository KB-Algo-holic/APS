# BOJ 17404 - RGB거리 2
# 유형: DP
# 링크: https://www.acmicpc.net/problem/17404

import sys
input = sys.stdin.readline
INF = 10**9

N = int(input())
costs = []
for _ in range(N):
    costs.append(list(map(int, input().split())))

answer = INF
for i in range(3):
    DP = [[INF, INF, INF] for _ in range(N)]
    DP[0][i] = costs[0][i]

    for j in range(1, N):
        DP[j][0] = costs[j][0] + min(DP[j-1][1], DP[j-1][2])
        DP[j][1] = costs[j][1] + min(DP[j-1][0], DP[j-1][2])
        DP[j][2] = costs[j][2] + min(DP[j-1][0], DP[j-1][1])
    
    for k in range(3):
        if i != k:
            answer = min(DP[-1][k], answer)

print(answer)