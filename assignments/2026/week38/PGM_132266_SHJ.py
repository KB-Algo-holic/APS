# PGM 132266 - 부대복귀
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/132266



from collections import deque

def solution(n, roads, sources, destination):
    graph = [[] for _ in range(n + 1)]

    for a, b in roads:
        graph[a].append(b)
        graph[b].append(a)

    distance = [-1] * (n + 1)
    distance[destination] = 0

    queue = deque([destination])

    while queue:
        now = queue.popleft()

        for next_node in graph[now]:
            if distance[next_node] == -1:
                distance[next_node] = distance[now] + 1
                queue.append(next_node)

    return [distance[s] for s in sources]
