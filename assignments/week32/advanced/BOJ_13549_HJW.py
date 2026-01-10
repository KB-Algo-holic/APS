# BOJ 13549 - 숨바꼭질 3
# 유형: BFS
# 링크: https://www.acmicpc.net/problem/13549

from collections import deque

dx = [1, -1]
M = 200001

N, K = map(int, input().split())

queue = deque()
visited = [0] * M
x = N
while x < M:
    visited[x] = 1
    queue.append(x)
    x *= 2
    
    if not x:
        break

while queue:
    node = queue.popleft()
    step = visited[node]
    
    if node == K:
        break
    
    for i in range(2):
        x = node + dx[i]
        if x < 0:
            continue
            
        while x < M:
            if visited[x]:
                break
            visited[x] = step+1
            queue.append(x)
            x *= 2
            
            if not x:
                break
            
print(step-1)