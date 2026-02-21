# BOJ 11404 - 플로이드
# 유형: 플로이드-워셜
# 링크: https://www.acmicpc.net/problem/11404

import sys
input = sys.stdin.readline
INF = 10**9

N = int(input())
M = int(input())
grid = [[INF for _ in range(N+1)] for _ in range(N+1)]

for i in range(N+1):
    grid[i][i] = 0

for _ in range(M):
    a, b, cost = map(int, input().split())
    grid[a][b] = min(grid[a][b], cost)

for k in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            grid[i][j] = min(grid[i][j], grid[i][k]+grid[k][j])

for i in range(N+1):
    for j in range(N+1):
        if grid[i][j] == INF:
            grid[i][j] = 0

for i in range(1, N+1):
    print(*grid[i][1:])