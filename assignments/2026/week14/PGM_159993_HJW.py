# PGM 159993 - 미로 탈출
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/159993

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(maps, start, end):
    
    N, M = len(maps), len(maps[0])
    visited = [[0 for _ in range(M)] for _ in range(N)]
    visited[start[0]][start[1]] = 1
    queue = deque()
    queue.append(start)
    
    while queue:
        node = queue.popleft()
        a, b = node[0], node[1]
        step = visited[a][b]
        
        for i in range(4):
            x, y = a + dx[i], b + dy[i]
            if 0 <= x < N and 0 <= y < M and not visited[x][y] and maps[x][y] != 'X':
                visited[x][y] = step + 1
                queue.append([x, y])
    
    return visited[end[0]][end[1]] - 1

def solution(maps):
    answer = 0
    
    start = []
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == "S":
                start = [i, j]
                break
        if start:
            break
    
    end = []
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == "E":
                end = [i, j]
                break
        if end:
            break
    
    lock = []
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == "L":
                lock = [i, j]
                break
        if lock:
            break
    
    first = bfs(maps, start, lock)
    if first == -1:
        return first
    
    second = bfs(maps, lock, end)
    if second == -1:
        return second
    
    answer = first + second
    return answer