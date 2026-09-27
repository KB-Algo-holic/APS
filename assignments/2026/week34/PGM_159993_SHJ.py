// PGM 159993 - 미로 탈출
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/159993?language=python3

from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])

    start = None
    lever = None
    end = None

    # 시작점, 레버, 출구 위치 찾기
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'S':
                start = (i, j)
            elif maps[i][j] == 'L':
                lever = (i, j)
            elif maps[i][j] == 'E':
                end = (i, j)

    def bfs(start, target):
        q = deque()
        q.append((start[0], start[1], 0))

        visited = [[False] * m for _ in range(n)]
        visited[start[0]][start[1]] = True

        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]

        while q:
            x, y, cnt = q.popleft()

            if (x, y) == target:
                return cnt

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < n and 0 <= ny < m:
                    if maps[nx][ny] != 'X' and not visited[nx][ny]:
                        visited[nx][ny] = True
                        q.append((nx, ny, cnt + 1))

        return -1

    # 시작점 -> 레버
    first = bfs(start, lever)

    if first == -1:
        return -1

    # 레버 -> 출구
    second = bfs(lever, end)

    if second == -1:
        return -1

    return first + second
