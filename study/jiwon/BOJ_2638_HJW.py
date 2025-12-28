# BOJ 2638 - 치즈
# 유형: BFS
# 링크: https://www.acmicpc.net/problem/2638

import sys
input = sys.stdin.readline
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

N, M = map(int, input().split())
grid = []
for _ in range(N):
    grid.append(list(map(int, input().split())))

def find_out():
    queue = deque()
    queue.append([0, 0])
    visited = [[0 for _ in range(M)] for _ in range(N)]
    visited[0][0] = 1
    
    while queue:
        node = queue.popleft()
        a, b = node[0], node[1]
        
        for i in range(4):
            x, y = a + dx[i], b + dy[i]
            
            if 0 <= x < N and 0 <= y < M and not visited[x][y] and not grid[x][y]:
                visited[x][y] = 1
                queue.append([x, y])
    
    new_grid = [[0 for _ in range(M)] for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if not grid[i][j] and visited[i][j]:
                new_grid[i][j] = 1
    
    return new_grid

def find_corner(visited, x_, y_, outs):
    queue = deque()
    queue.append([x_, y_])
    visited[x_][y_] = 1
    
    corner = []
    
    while queue:
        node = queue.popleft()
        a, b = node[0], node[1]
        
        cnt = 0
        for i in range(4):
            x, y = a + dx[i], b + dy[i]
            
            if 0 <= x < N and 0 <= y < M:
                if outs[x][y]:
                    cnt += 1
                
                if not visited[x][y] and grid[x][y]:
                    visited[x][y] = 1
                    queue.append([x, y])
        
        if cnt >= 2:
            corner.append([a, b])
    
    return corner

answer = 0
while True:
    
    outs = find_out()
    visited = [[0 for _ in range(M)] for _ in range(N)]
    
    corners = []
    for i in range(N):
        for j in range(M):
            if grid[i][j] and not visited[i][j]:
                corner = find_corner(visited, i, j, outs)
                corners.extend(corner)
    
    if corners:
        for (x, y) in corners:
            grid[x][y] = 0
    
    else:
        break
    
    answer += 1

print(answer)