# PGM 1844 - 게임 맵 최단거리
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def solution(maps):
    n, m = len(maps), len(maps[0])
    visited = [[0 for _ in range(m)] for _ in range(n)]
    queue = deque()
    visited[0][0] = 1
    queue.append([0, 0])
    
    while queue:
        node = queue.popleft()
        a, b = node[0], node[1]
        step = visited[a][b]
        
        for i in range(4):
            x, y = a + dx[i], b + dy[i]
            
            if 0 <= x < n and 0 <= y < m and not visited[x][y] and maps[x][y]:
                visited[x][y] = step+1
                queue.append([x, y])
        
        if visited[n-1][m-1]:
            break
    
    return visited[n-1][m-1] if visited[n-1][m-1] else -1