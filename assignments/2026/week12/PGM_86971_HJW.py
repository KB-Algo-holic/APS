# PGM 86971 - 전력망을 둘로 나누기
# 유형: 트리
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/86971

from collections import deque

def bfs(start, connection, n):
    
    visited = [0] * n
    visited[start] = 1
    queue = deque()
    queue.append(start)
    
    while queue:
        node = queue.popleft()
        for i in range(n):
            if connection[node][i] and not visited[i]:
                visited[i] = 1
                queue.append(i)
    
    return sum(visited)

def solution(n, wires):
    answer = n+1
    
    connection = [[0 for _ in range(n)] for _ in range(n)]
    for wire in wires:
        a, b = wire[0]-1, wire[1]-1
        connection[a][b] = 1
        connection[b][a] = 1
    
    for wire in wires:
        a, b = wire[0]-1, wire[1]-1
        connection[a][b] = 0
        connection[b][a] = 0
        Min = abs(bfs(a, connection, n) - bfs(b, connection, n))
        if Min < answer:
            answer = Min
        connection[a][b] = 1
        connection[b][a] = 1
    return answer