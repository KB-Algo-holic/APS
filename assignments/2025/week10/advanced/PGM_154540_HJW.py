# PGM 154540 - 무인도 여행
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/154540

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def solution(maps):
    
    answer = []
    width = [0] * 10001
    N, M = len(maps), len(maps[0])
    queue = deque()
    visited = [[0 for _ in range(M)] for _ in range(N)]
    cnt = 1
    for i in range(N):
        for j in range(M):
            if not visited[i][j] and maps[i][j] != "X":
                visited[i][j] = 1
                queue.append([i, j])
                
                while queue:
                    node = queue.popleft()
                    a, b = node[0], node[1]
                    width[cnt] += int(maps[a][b])
                    
                    for d in range(4):
                        x, y = a+dx[d], b+dy[d]
                        if 0 <= x < N and 0 <= y < M and not visited[x][y] and maps[x][y] != "X":
                            visited[x][y] = 1
                            queue.append([x, y])
                cnt += 1
    for i in range(1, cnt):
        answer.append(width[i])
    answer.sort()
    if not answer:
        answer.append(-1)
    return answer