// PGM 49189 - 가장 먼 노드
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=python3


from collections import deque

def solution(n, vertex):
    graph = [[] for _ in range(n + 1)]

    for a, b in vertex:
        graph[a].append(b)
        graph[b].append(a)

    distance = [-1] * (n + 1)
    distance[1] = 0

    q = deque([1])

    while q:
        now = q.popleft()

        for nxt in graph[now]:
            if distance[nxt] == -1:  
                distance[nxt] = distance[now] + 1
                q.append(nxt)

    max_distance = max(distance)

    return distance.count(max_distance)
