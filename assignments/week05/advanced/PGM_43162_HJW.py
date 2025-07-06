# PGM 43162 - 네트워크
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162

from collections import deque

def solution(n, computers):
    answer = 0
    
    visited = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        if not visited[i][i]:
            answer += 1
            visited[i][i] = 1
            queue = deque()
            queue.append(i)
            
            while queue:
                node = queue.popleft()
                
                for j in range(n):
                    if not visited[node][j] and computers[node][j]:
                        visited[node][j] = 1
                        queue.append(j)
                    
    return answer