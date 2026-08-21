# PGM 132266 - 부대복귀
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/132266

from collections import deque

def solution(n, roads, sources, destination):
    answer = []
    grid = [[] for _ in range(n)]
    for road in roads:
        a, b = road[0]-1, road[1]-1
        grid[a].append(b)
        grid[b].append(a)

    visited = [0] * n
    visited[destination-1] = 1
    queue = deque()
    queue.append(destination-1)
    
    while queue:
        node = queue.popleft()
        step = visited[node]
        for x in grid[node]:
            if not visited[x]:
                visited[x] = step+1
                queue.append(x)
                
    for source in sources:
        answer.append(visited[source-1]-1)
    
    return answer