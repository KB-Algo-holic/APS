# BOJ 1753 - 최단경로
# 유형: 다익스트라
# 링크: https://www.acmicpc.net/problem/1753

import sys
import heapq
input = sys.stdin.readline
INF = 10**9

V, E = map(int, input().split())
S = int(input())
grid = dict()
for _ in range(E):
    a, b, d = map(int, input().split())
    if grid.get(a):
        if grid[a].get(b):
            grid[a][b] = min(grid[a][b], d)
        else:
            grid[a][b] = d
    
    else:
        grid[a] = dict()
        grid[a][b] = d

for i in range(1, V+1):
    if grid.get(i):
        grid[i][i] = 0
    else:
        grid[i] = dict()
        grid[i][i] = 0

distance = [INF] * (V+1)
distance[S] = 0
visited = [0] * (V+1)
heap = []
heapq.heappush(heap, (0, S)) # now까지 거리, now
while heap:
    node = heapq.heappop(heap)
    distance_to_now, now = node[0], node[1]
    for node in grid[now]:
        if distance[node] > distance_to_now + grid[now][node]:
            distance[node] = distance_to_now + grid[now][node]
            heapq.heappush(heap, (distance[node], node))

for i in range(1, V+1):
    print(distance[i] if distance[i] != INF else "INF")