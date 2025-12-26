# BOJ 7576 - 토마토
# 유형: DFS
# 링크: https://www.acmicpc.net/problem/7576

import sys
from collections import deque

M, N = map(int, sys.stdin.readline().rstrip().split(' '))

box = []
for _ in range(N):
    box.append(sys.stdin.readline().rstrip().split(' '))

visited = [[0 for _ in range(M)] for __ in range(N)]

queue = deque()

for i in range(N):
    for j in range(M):
        if box[i][j] == '1':
            queue.append([i, j, 0])

day = 0
while queue:
    if queue[0][2] == day:
        node = queue.popleft()
        x, y = node[0], node[1]
        box[x][y] = '1'
        visited[x][y] = 1
        if x < N-1 and box[x+1][y] == '0' and visited[x+1][y] == 0:
            queue.append([x+1, y, day+1])
            visited[x+1][y] = 1
        if x > 0 and box[x-1][y] == '0' and visited[x-1][y] == 0:
            queue.append([x-1, y, day+1])
            visited[x-1][y] = 1
        if y < M-1 and box[x][y+1] == '0' and visited[x][y+1] == 0:
            queue.append([x, y+1, day+1])
            visited[x][y+1] = 1
        if y > 0 and box[x][y-1] == '0' and visited[x][y-1] == 0:
            queue.append([x, y-1, day+1])
            visited[x][y-1] = 1
    else:
        day += 1

for i in range(N):
    for j in range(M):
        if box[i][j] == '0':
            day = -1
            break
    if day == -1:
        break

print(day)