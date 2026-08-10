# PGM 250136 - 석유 시추
# 유형: 그래프 탐색(BFS, DFS)
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250136

from collections import deque

def solution(land):
    n = len(land)
    m = len(land[0])

    visited = [[False] * m for _ in range(n)]
    result = [0] * m

    move = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    for i in range(n):
        for j in range(m):

            if land[i][j] == 0 or visited[i][j]:
                continue

            queue = deque([(i, j)])
            visited[i][j] = True

            count = 0
            col = set()

            while queue:
                x, y = queue.popleft()

                count += 1
                col.add(y)

                for dx, dy in move:
                    nx = x + dx
                    ny = y + dy

                    if 0 <= nx < n and 0 <= ny < m:
                        if land[nx][ny] == 1 and not visited[nx][ny]:
                            visited[nx][ny] = True
                            queue.append((nx, ny))

            for c in col:
                result[c] += count

    return max(result)
