# PGM 132266 - 부대복귀
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/132266

from collections import deque

def solution(n, roads, sources, destination):
    
    grid = [[] for _ in range(n+1)]
    for road in roads:
        a, b = road[0], road[1]
        grid[a].append(b)
        grid[b].append(a)
    
    visited = [-1] * (n+1)
    visited[destination] = 0
    queue = deque([destination])
    
    while queue:
        node = queue.popleft()
        step = visited[node]
        
        for x in grid[node]:
            if visited[x] == -1:
                visited[x] = step+1
                queue.append(x)
        
    return [visited[x] for x in sources]