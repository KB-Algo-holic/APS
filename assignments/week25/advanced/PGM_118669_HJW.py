# PGM 118669 - 등산코스 정하기
# 유형: 다익스트라 / DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/118669

from heapq import heappop, heappush
INF = 10**9

def solution(n, paths, gates, summits):
    
    answer = [INF, INF]
    grid = [{} for _ in range(n+1)]
    for path in paths:
        a, b, d = path[0], path[1], path[2]
        grid[a][b] = min(grid[a].get(b, INF), d)
        grid[b][a] = min(grid[b].get(a, INF), d)
        
    summits.sort()
    is_summit = [0] * (n+1)
    for s in summits:
        is_summit[s] = 1
    
    gates.sort()
    is_gate = [0] * (n+1)
    for g in gates:
        is_gate[g] = 1
    
    DP = [INF] * (n+1)
    for summit in summits:
        distance = [INF] * (n+1)
        distance[summit] = 0
        heap = []
        heappush(heap, (0, summit))
        
        while heap:
            node = heappop(heap)
            dist, now = node[0], node[1]
            
            if dist > DP[summit]:
                continue
            
            if is_gate[now]:
                if dist < DP[summit]:
                    DP[summit] = dist
                continue
            
            for node in grid[now]:
                value = max(dist, grid[now][node])
                if not is_summit[node] and distance[node] > value and value < DP[summit]:
                    distance[node] = value
                    heappush(heap, (value, node))
        
    for summit in summits:
        if answer[1] > DP[summit]:
            answer = [summit, DP[summit]]
        
    return answer