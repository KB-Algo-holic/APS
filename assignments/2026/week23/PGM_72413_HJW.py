# PGM 72413 - 합승 택시 요금
# 유형: 다익스트라
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72413

from heapq import heappop, heappush

def dijkstra(start, n, grid):
    
    INF = 10**9
    
    distance = [INF] * (n+1)
    distance[start] = 0
    heap = []
    heappush(heap, (start, 0))
    
    while heap:
        node = heappop(heap)
        now, dis = node[0], node[1]
        
        for node in grid[now]:
            tmp_dis = dis + grid[now][node]
            if distance[node] > tmp_dis:
                distance[node] = tmp_dis
                heappush(heap, (node, tmp_dis))
    
    return distance

def solution(n, s, a, b, fares):
    answer = 0
    grid = [dict() for _ in range(n+1)]
    for (x, y, cost) in fares:
        grid[x][y] = cost
        grid[y][x] = cost
    
    for i in range(n+1):
        grid[i][i] = 0
    
    a_distance = dijkstra(a, n, grid)
    b_distance = dijkstra(b, n, grid)
    s_distance = dijkstra(s, n, grid)
    
    answer = a_distance[s] + b_distance[s]
    for i in range(1, n+1):
        tmp = s_distance[i] + a_distance[i] + b_distance[i]
        if tmp < answer:
            answer = tmp
    
    return answer