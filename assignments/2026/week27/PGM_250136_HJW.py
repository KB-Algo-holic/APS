# PGM 250136 - 석유 시추
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250136

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def solution(land):

    n, m = len(land), len(land[0])
    answer = [0] * m
    visited = [[0 for _ in range(m)] for _ in range(n)]
    for j in range(m):
        for i in range(n):
            if land[i][j] and not visited[i][j]:
                queue = deque()
                queue.append([i, j])
                visited[i][j] = 1
                cnt = 0
                l, r = j, j
                
                while queue:
                    node = queue.popleft()
                    cnt += 1
                    a, b = node[0], node[1]
                    if b < l:
                        l = b
                    if b > r:
                        r = b
                    
                    for k in range(4):
                        x, y = a + dx[k], b + dy[k]
                        
                        if 0 <= x < n and 0 <= y < m and not visited[x][y] and land[x][y]:
                            visited[x][y] = 1
                            queue.append([x, y])
                
                for k in range(l, r+1):
                    answer[k] += cnt
    
    return max(answer)
        